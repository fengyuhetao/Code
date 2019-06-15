package creational.singleton;

/**
 * 懒汉式
 * 多线程不安全
 *
 * @author HT
 * @version V1.0
 * @package creational.singleton
 * @date 2019-06-15 23:29
 */
public class LazySingleton {
    private static LazySingleton lazySingleton = null;

    private LazySingleton() {

    }

    public synchronized static LazySingleton getInstance() {
        if(lazySingleton == null) {
            lazySingleton = new LazySingleton();
        }
        return lazySingleton;
    }
}
