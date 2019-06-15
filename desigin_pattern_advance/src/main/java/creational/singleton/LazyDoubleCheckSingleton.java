package creational.singleton;

/**
 * @author HT
 * @version V1.0
 * @package creational.singleton
 * @date 2019-06-15 23:51
 */
public class LazyDoubleCheckSingleton {
    private volatile static LazyDoubleCheckSingleton lazyDoubleCheckSingleton = null;

    private LazyDoubleCheckSingleton() {

    }

    public static LazyDoubleCheckSingleton getInstance() {
        if(lazyDoubleCheckSingleton == null) {
            synchronized (LazyDoubleCheckSingleton.class) {
                if(lazyDoubleCheckSingleton == null) {
                    /**
                     * 1. 分配内存给这个对象
                     * 2. 初始化对象
                     * 3. 设置lazyDoubleCheckSingleton指向内存地址
                     *
                     * 2,3两步存在重排序
                     * intra-thread  semantics 保证重排序不会改变单线程最终执行结果
                     */
                    lazyDoubleCheckSingleton = new LazyDoubleCheckSingleton();
                }
            }
        }
        return lazyDoubleCheckSingleton;
    }
}
