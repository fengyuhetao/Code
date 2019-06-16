package creational.singleton;

/**
 * @author HT
 * @version V1.0
 * @package creational.singleton
 * @date 2019-06-16 00:11
 */
public class StaticInnerClassSingleton {
    private static class InnerClass {
        private static StaticInnerClassSingleton staticInnerClassSingleton = new StaticInnerClassSingleton();
    }

    private StaticInnerClassSingleton() {
        if(InnerClass.staticInnerClassSingleton != null) {
            throw new RuntimeException("单例模式");
        }
    }

    public static StaticInnerClassSingleton getInstance() {
        return InnerClass.staticInnerClassSingleton;
    }
}
