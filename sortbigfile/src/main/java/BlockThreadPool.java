import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 自定义阻塞型线程池
 *
 * @author HT
 * @version V1.0
 * @package PACKAGE_NAME
 * @date 2019-05-11 19:28
 */
public class BlockThreadPool {
    private ThreadPoolExecutor threadPoolExecutor = null;

    public BlockThreadPool(int poolSize) {
        this.threadPoolExecutor =  new ThreadPoolExecutor(poolSize, poolSize, 0, TimeUnit.MICROSECONDS, new ArrayBlockingQueue<Runnable>(poolSize),
                new CustomThreadFactory(), new CustomRejectedExecutionHandler());
    }

    private class CustomThreadFactory implements ThreadFactory {
        private AtomicInteger count = new AtomicInteger(0);

        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(r);
            String threadName = BlockThreadPool.class.getSimpleName() + count.addAndGet(1);
            t.setName(threadName);
            return t;
        }
    }

    private class CustomRejectedExecutionHandler implements RejectedExecutionHandler{

        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            try {
                // 核心改造，有blockingqueue的offer改为put阻塞方法
                executor.getQueue().put(r);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void execute(Runnable runnable) {
        this.threadPoolExecutor.execute(runnable);
    }

    public void shutdown() {
        this.threadPoolExecutor.shutdown();
    }

    public static void main(String[] args) {
        System.out.println(Math.floor(1600 /1000) + 1);
        BlockThreadPool blockThreadPool = new BlockThreadPool(3);
        for(int i = 0; i < 5; i++) {
            System.out.println("提交第" + i + "个任务");
            blockThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println(Thread.currentThread().getId() + " " + Thread.currentThread().getName() + "==开始");
                        TimeUnit.SECONDS.sleep(10);
                        System.out.println(Thread.currentThread().getId() + " " + Thread.currentThread().getName() + "==结束");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            System.out.println("提交第" + i + "个任务成功");
        }
    }

}
