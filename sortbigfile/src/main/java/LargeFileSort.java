import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.*;
import java.util.concurrent.*;

/**
 * '
 *
 * @author HT
 * @version V1.0
 * @package PACKAGE_NAME
 * @date 2019-05-11 20:59
 */
public class LargeFileSort {
    /**
     * 测试文件和结果文件路径，改变环境修改此地址
     */
    private final static String ROOT_FILE_PATH = "D:\\Code\\sortbigfile\\src\\main\\resources\\data";

    /**
     * 测试文件
     */
    private static String[] genFiles = new String[10];

    /**
     * 初分大文件,默认是2M
     */
    private final static int SIZE = 1024;

    private final static int BYTE_SIZE = SIZE * 1024;

    /**
     * 线程任务完成计数器
     */
    private static CountDownLatch doneSingle;

    private static final List<File> divFiles = new CopyOnWriteArrayList<File>();

    public static void main(String[] args) throws IOException {
        Long root = System.currentTimeMillis();
        generateTestFiles();
        Long gen = System.currentTimeMillis();
        System.out.println("\n*************************");
        System.out.println(String.format("初始化数据完成: %s s", (gen - root) / 1000));
        System.out.println("******************************");
        Long divStart = System.currentTimeMillis();
        divisonAndSortFiles(2);
        Long divEnd = System.currentTimeMillis();
        System.out.println("********************");
        System.out.println(String.format("切分数据完成: %s s", (divEnd - divStart) / 1000));
        System.out.println("********************");

        Long mergeStart = System.currentTimeMillis();
        // 最终合并所有小文件
        merge();
        Long mergeEnd = System.currentTimeMillis();
        System.out.println("\n***************");
        System.out.println(String.format("合并完成:%s 秒。", (mergeEnd - mergeStart) / 1000));
        System.out.println("\n***************");
        System.out.println(
                String.format("排序完成:%s s。 %s 分钟 。", (mergeEnd - divStart) / 1000, (mergeEnd - divStart) / 1000 / 60));
        System.out.println("***************");
        System.out.println("最终文件地址：" + divFiles.get(0).getAbsolutePath());
        // 验证
        validation();
    }

    private static void validation() throws IOException{
        System.out.println("执行验证");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(divFiles.get(0).getAbsolutePath())));
        String line = "";
        String pre = bufferedReader.readLine();
        while((line = bufferedReader.readLine()) != null) {
            if(Integer.parseInt(line.trim()) < Integer.parseInt(pre.trim())) {
                System.out.println("验证不通过");
                System.exit(0);
            }
        }
        System.out.println("验证通过");
    }

    private static void merge() throws IOException {
        List<File> divFiles2 = new ArrayList<File>(divFiles);
        divFiles.clear();
        //如果文件数小于20，直接合并
        if(divFiles2.size() < 20) {
            mergeLargeFile(divFiles2, ROOT_FILE_PATH + "/resultFile.txt");
            return;
        }

        List<List<File>> divTwo = new ArrayList<List<File>>();
        // 处理任务，15个小文佳为一组
        for(int i = 0; i < divFiles2.size(); i += 15) {
            List<File> files = new ArrayList<File>();
            for(int j = i; j < divFiles2.size() && j < (i + 15); j++) {
                files.add(divFiles2.get(j));
            }
            divTwo.add(files);
        }

        // 定义一个三个线程的阻塞线程池
        BlockThreadPool blockThreadPool = new BlockThreadPool(3);
        doneSingle = new CountDownLatch(divTwo.size());
        for(int i = 0; i< divTwo.size(); i++) {
            blockThreadPool.execute(new mergeTask(divTwo.get(i), ROOT_FILE_PATH + "/temp_result" + i + ".txt"));
        }

        try {
            // 等待合并文件完成
            doneSingle.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        blockThreadPool.shutdown();
        System.out.println("最终合并");
        File resultFile = mergeLargeFile(divFiles, ROOT_FILE_PATH + "/temp_result_all.txt");
        divFiles.clear();
        divFiles.add(resultFile);
    }

    static class mergeTask implements Runnable{
        private final List<File> files;

        private final String fileName;

        public mergeTask(List<File> files, String fileName) {
            this.files = files;
            this.fileName = fileName;
        }

        @Override
        public void run() {
            try{
                File file = mergeLargeFile(files, fileName);
                divFiles.add(file);
                doneSingle.countDown();
                System.out.println("完成初步合并任务," + doneSingle.getCount());
            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
    }

    /**
     * 合并多个小文件
     * 
     * @param divFiles2
     * @param fileName     结果存放文件
     * @throws IOException
     */
    private static File mergeLargeFile(List<File> divFiles2, String fileName) throws IOException {
        List<FileEntity> fileEntities = new ArrayList<FileEntity>();
        for(int i = 0; i< divFiles2.size(); i++) {
            FileEntity fileEntity = new FileEntity(new BufferedReader(new InputStreamReader(new FileInputStream(divFiles2.get(i)))));
            fileEntities.add(fileEntity);
        }
        
        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName)));
            int count = 0;
            FileEntity fileEntity = null;
            StringBuilder stringBuilder = new StringBuilder();
            while((fileEntity = getFirstFileEntity(fileEntities)) != null) {
                count++;
//                写入符合条件的一条数据
                stringBuilder.append(fileEntity.getLine()).append("\n");
                // 准备下一行
                fileEntity.nextLine();
                // 清理缓冲流
                if((count + 1) % 10000 == 0) {
                    bufferedWriter.write(stringBuilder.toString());
                    stringBuilder.setLength(0);
                    bufferedWriter.flush();
                }
            }

            if(stringBuilder.length() > 0) {
                bufferedWriter.write(stringBuilder.toString());
                bufferedWriter.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedWriter != null) {
                    bufferedWriter.flush();
                    bufferedWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        for(int i = 0; i< fileEntities.size(); i++) {
            fileEntities.get(i).close();
        }

        return new File(fileName);
    }

    private static FileEntity getFirstFileEntity(List<FileEntity> fileEntities) {
        if(fileEntities.size() == 0) {
            return null;
        }

        // 如果文件读到底，就删除该文件流
        Iterator<FileEntity> iterator = fileEntities.iterator();
        while(iterator.hasNext()) {
            FileEntity fileEntity = iterator.next();
            if(fileEntity.getLine() == null) {
                fileEntity.close();
                iterator.remove();
            }
        }

        if(fileEntities.size() == 0) {
            return null;
        }

        // 排序获取一行数据
        fileEntities.sort(new FileEntityComparator());
        return  fileEntities.get(0);
    }

    private static void divisonAndSortFiles(int concurrentNum) {
        //自定义线程池
        BlockThreadPool blockThreadPool = new BlockThreadPool(concurrentNum);
        //切分任务开始
        doneSingle = new CountDownLatch(10);
        for(int i = 0; i< 10; i++) {
            blockThreadPool.execute(new divWorkTask(genFiles[i]));
        }

        try {
            doneSingle.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        blockThreadPool.shutdown();
    }

    /**
     * 产生测试文件
     */
    private static void generateTestFiles() {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        doneSingle = new CountDownLatch(10);
        for(int i = 0; i< 10; i++) {
            genFiles[i] = ROOT_FILE_PATH + "/originalData" + i + ".txt";
            executorService.submit(new generateTestFileTask(genFiles[i]));
        }

        try {
            doneSingle.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        executorService.shutdown();
    }

    static class generateTestFileTask implements Runnable {
        final String filePath;

        public generateTestFileTask(String filePath) {
            this.filePath = filePath;
        }

        @Override
        public void run() {
            try {
                generateTestFile(filePath);
                doneSingle.countDown();
                System.out.println("生成文件:" + doneSingle.getCount());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static void generateTestFile(String filePath) throws Exception {
        Random random = new Random();
        StringBuffer stringBuffer = new StringBuffer();
        FileChannel fileChannel = null;
        RandomAccessFile randomAccessFile = null;
        try {
            File testFile = new File(filePath);
            if(testFile.exists()) {
                testFile.delete();
            }
            testFile.createNewFile();

            randomAccessFile = new RandomAccessFile(testFile, "rw");
            fileChannel = randomAccessFile.getChannel();

            int capacity = 1024 * 1024;
            ByteBuffer writeBuffer = ByteBuffer.allocate(capacity);
            for(long i = 0; i< 1000 * 10000; i++) {
                stringBuffer.append(random.nextInt(100000)).append("\n");
                // 刷新缓冲
                if((i + 1) % 10000 == 0) {
                    writeBuffer.put(stringBuffer.toString().getBytes());
                    stringBuffer.setLength(0);
                    writeBuffer.flip();
                    fileChannel.write(writeBuffer);
                    writeBuffer.clear();
                }
            }

            if(stringBuffer.length() > 0) {
                writeBuffer.put(stringBuffer.toString().getBytes());
                writeBuffer.flip();
                fileChannel.write(writeBuffer);
                writeBuffer.clear();
            }
        } catch (IOException e) {
            System.out.println("生成测试文件失败:" + e.getMessage());
            throw e;
        } finally {
            try {
                if(randomAccessFile != null) {
                    randomAccessFile.close();
                }
            } catch (IOException e) {

            }

            try {
                if(fileChannel.isOpen()) {
                    fileChannel.close();
                }
            } catch (IOException e) {

            }
        }
    }

    /**
     * 分割文件
     */
    static class divWorkTask implements Runnable {
        final String filePath;

        public divWorkTask(String filePath) {
            this.filePath = filePath;
        }

        @Override
        public void run() {
            try {
                List<File> lists = divWork(filePath);
                divFiles.addAll(lists);
                doneSingle.countDown();
                System.out.println("完成分割任务:" + doneSingle.getCount());
            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
    }

    public static List<File> divWork(String filePath) throws IOException {
        File file = new File(filePath);
        if(!file.exists()) {
            throw new Error("文件不存在");
        }
        
        // 得到文件大小 kb 为单位
        int mbSize = (int) Math.ceil(file.length() / 1024);
        
        // 得到切分之后的文件数 SIZE = 1024 * 10
        int fileNum = (int) Math.ceil(mbSize / SIZE) + 1;
        
        // 创建临时文件
        List<File> tempFileList = createTempFileList(file, fileNum);
        
//        切分文件
        divAndSort(file, tempFileList);
        return tempFileList;
    }

    private static List<File> createTempFileList(File file, int fileNum) {
        List<File> tempFileList = new ArrayList<File>();
        String fileFolder = file.getParent();
        String name = file.getName();
        for(int i = 0; i< fileNum; i++) {
            // 创建临时文件
            File tempFile = new File(fileFolder + "/" + name + ".temp_" + i + ".txt");
//            如果存在就删除
            if(tempFile.exists()) {
                tempFile.delete();
            }

            try {
                tempFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }

            tempFileList.add(tempFile);
        }

        return tempFileList;
    }

    /**
     * 切分文件并做第一次排序
     *
     * @param file
     * @param tempFileList
     */
    private static void divAndSort(File file, List<File> tempFileList) {
        BufferedReader bufferedReader = null;
        try {
//            读取大文件
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));

//            行数据保存对象
            String line = null;

            //临时文件索引
            int index = tempFileList.size() - 1;

            //保存数据
            List<String> lineList = new ArrayList<String>();

            // 统计文件大小
            int byteSum = 0;

//            循环临时文件并循环大文件
            while((line = bufferedReader.readLine()) != null) {
                line += "\n";
                byteSum += line.getBytes().length;
//                如果长度达到每个文件大小，就重新计算
                if(byteSum >= BYTE_SIZE) {
                    Long time = System.currentTimeMillis();
//                    写入到文件
                    putLineListToFile(tempFileList.get(index), lineList);
                    Long time1 = System.currentTimeMillis();
                    System.out.println(String.format("写入文件%s, %s ms", index, time1 - time));
                    index--;
                    byteSum = line.getBytes().length;
                    lineList.clear();
                }
                lineList.add(line);
            }
            if(lineList.size() > 0) {
                putLineListToFile(tempFileList.get(0), lineList);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void putLineListToFile(File file, List<String> lineList) throws IOException {
        FileOutputStream tempFileFos = null;
        try {
//            第一次写入文件
            lineList.sort(new LineComparator());
            tempFileFos = new FileOutputStream(file);
            StringBuilder stringBuilder = new StringBuilder();
            for(int i = 0; i< lineList.size(); i++) {
                stringBuilder.append(lineList.get(i));
                if((i + 1) % 1000 == 0) {
                    tempFileFos.write(stringBuilder.toString().getBytes());
                    stringBuilder.setLength(0);
                }
            }
            if(stringBuilder.length() > 0) {
                tempFileFos.write(stringBuilder.toString().getBytes());
            }
            stringBuilder = null;
        } finally {
            if(tempFileFos != null) {
                tempFileFos.close();
            }
        }
    }

    /**
     * @param o1
     * @param o2
     * @return
     */
    public static int compare(String o1, String o2) {
        o1 = o1.trim();
        o2 = o2.trim();
        // 从小到大
        return Integer.parseInt(o1) - Integer.parseInt(o2);
        // 从大到小
        // return Integer.parseInt(o2) - Integer.parseInt(o1);
    }
}

/**
 * 排序
 */
class LineComparator implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        return LargeFileSort.compare(o1, o2);
    }
}


/**
 * 排序类
 */
class FileEntityComparator implements Comparator<FileEntity> {
    @Override
    public int compare(FileEntity o1, FileEntity o2) {
        return LargeFileSort.compare(o1.getLine(), o2.getLine());
    }
}