import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author HT
 * @version V1.0
 * @package PACKAGE_NAME
 * @date 2019-04-22 21:46
 */
public class CacheData {
    Object data;
    //缓存是否有效
    volatile boolean cacheValid;
    ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();

    void processCachedData() {
        //获取读锁
        rwl.readLock().lock();
        //如果缓存无效则更新cache，否则直接使用data
        if (!cacheValid) {
            // Must release read lock before acquiring write lock
            //获取写锁前须先释放读锁
            rwl.readLock().unlock();
            rwl.writeLock().lock();
            // Recheck state because another thread might have acquired
            //   write lock and changed state before we did.
            if (!cacheValid) {
                data = "ad";
                cacheValid = true;
            }
            // Downgrade by acquiring read lock before releasing write lock
            //锁降级操作！在释放写锁前需先获取读锁
            rwl.readLock().lock();
            rwl.writeLock().unlock(); // Unlock write, still hold read
        }

//            use(data);
        //释放读锁
        rwl.readLock().unlock();
    }
}
