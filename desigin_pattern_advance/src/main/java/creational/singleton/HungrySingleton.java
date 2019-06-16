package creational.singleton;

import java.io.Serializable;

/**
 * @author HT
 * @version V1.0
 * @package creational.singleton
 * @date 2019-06-16 00:22
 */
public class HungrySingleton implements Serializable {
    private static final long serialVersionUID = -8913520554911894164L;

    private final static HungrySingleton hungrySingleton;

    static {
        hungrySingleton  = new HungrySingleton();
    }

    private HungrySingleton() {
        if(hungrySingleton != null) {
            throw new RuntimeException("单例构造器进制调用");
        }
    }

    public static HungrySingleton getInstance() {
        return hungrySingleton;
    }

    private Object readResolve() {
        return hungrySingleton;
    }
}
