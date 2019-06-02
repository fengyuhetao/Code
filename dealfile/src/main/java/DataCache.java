import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author HT
 * @version V1.0
 * @package PACKAGE_NAME
 * @date 2019-04-22 21:16
 */
public class DataCache {
    private Map<String, String> cachedMap = new HashMap<>();

    private ReadWriteLock lock = new ReentrantReadWriteLock();
    private final Lock readLock = lock.readLock();
    private final Lock writeLock = lock.writeLock();

    public long readSize() {
        try {
            readLock.lock();
            mockTimeConsumingOpt();
            return cachedMap.size();
        } finally {
            readLock.unlock();
        }
    }

    public long write(String key, String value) {
        try {
            writeLock.lock();
            mockTimeConsumingOpt();
            cachedMap.put(key, value);
            return cachedMap.size();
        } finally {
            writeLock.unlock();
        }
    }

    private void mockTimeConsumingOpt() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
