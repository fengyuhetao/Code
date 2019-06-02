import java.util.ArrayList;

/**
 * @author HT
 * @version V1.0
 * @package PACKAGE_NAME
 * @date 2019-04-22 21:17
 */
public class Test {

    /**
     *  从输出可以发现 ReentrantReadWriteLock 支持公平和非公平锁；还支持可重入特性，读线程在获取了读锁后还可以获取读锁，
     *  写线程在获取了写锁之后既可以再次获取写锁又可以获取读锁；此外还允许从写入锁降级为读取锁（操作方式是先获取写入锁，
     *  然后获取读取锁，最后释放写入锁），但是不允许从读取锁升级到写入锁，因为可能会出现数据不一致问题。
     */
    public static void main(String[] args) {
        final DataCache dataCache = new DataCache();

        ArrayList<Thread> worker = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                WriteThread writer = new WriteThread("Writer"+i, dataCache);
                worker.add(writer);
            } else {
                ReadThread reader = new ReadThread("Reader"+i, dataCache);
                worker.add(reader);
            }
        }

        for (int i = 0; i < worker.size(); i++) {
            worker.get(i).start();
        }
    }
}
