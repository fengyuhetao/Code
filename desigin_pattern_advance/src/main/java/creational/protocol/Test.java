package creational.protocol;

import creational.singleton.HungrySingleton;

import java.lang.reflect.Method;

/**
 * @author HT
 * @version V1.0
 * @package creational.protocol
 * @date 2019-06-18 23:35
 */
public class Test {
    public static void main(String[] args) throws  Exception{
        HungrySingleton hungrySingleton = HungrySingleton.getInstance();
        Method method = hungrySingleton.getClass().getDeclaredMethod("clone");
        method.setAccessible(true);
        HungrySingleton cloneHungrySingleton = (HungrySingleton) method.invoke(hungrySingleton);
        System.out.println(hungrySingleton == cloneHungrySingleton);
    }
}
