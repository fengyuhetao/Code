package creational.singleton;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * @author HT
 * @version V1.0
 * @package creational.singleton
 * @date 2019-06-15 23:30
 */
public class Test {
    public static void main(String[] args) throws Exception {
        testEnumInstanceReflect();
    }

    private static void testEnumInstanceReflect() throws Exception {
        Class objectClass = EnumInstance.class;
        Constructor constructor = objectClass.getDeclaredConstructor(String.class, Integer.class);

        constructor.setAccessible(true);
        EnumInstance instance = (EnumInstance) constructor.newInstance("haha", 666);
    }

    private static void testEnumInstance() throws Exception {
        EnumInstance instance = EnumInstance.getInstance();
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("singletonFile"));
        oos.writeObject(instance);
        File file = new File("singletonFile");
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        EnumInstance newInstance = (EnumInstance) ois.readObject();
        System.out.println(newInstance.getData());
        System.out.println(instance.getData());
    }

    private static void testLazySingletonAdvance() throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException, NoSuchMethodException {
        Class objectClass = LazySingleton.class;
        Constructor constructor = objectClass.getDeclaredConstructor();
        constructor.setAccessible(true);
        LazySingleton o1 = LazySingleton.getInstance();
        Field flag = o1.getClass().getDeclaredField("flag");
        flag.setAccessible(true);
        flag.set(o1, true);
        LazySingleton o2 = (LazySingleton) constructor.newInstance();
        System.out.println(o1 == o2);
    }

    public static void testLazySingletonReflect() throws Exception, InvocationTargetException, InstantiationException {
        Class objectClass = LazySingleton.class;
        Constructor constructor = objectClass.getDeclaredConstructor();
        constructor.setAccessible(true);

        LazySingleton instance = LazySingleton.getInstance();

        LazySingleton newInstance = (LazySingleton) constructor.newInstance();

        System.out.println(instance == newInstance);
    }


    public static void testStaticInnerClassSingleton() throws Exception, InvocationTargetException, InstantiationException {
        Class objectClass = StaticInnerClassSingleton.class;
        Constructor constructor = objectClass.getDeclaredConstructor();
        constructor.setAccessible(true);

        StaticInnerClassSingleton instance = StaticInnerClassSingleton.getInstance();

        StaticInnerClassSingleton newInstance = (StaticInnerClassSingleton) constructor.newInstance();

        System.out.println(instance == newInstance);
    }

    public void testHungrySingleton() throws Exception{
        Class objectClass = HungrySingleton.class;
        Constructor constructor = objectClass.getDeclaredConstructor();
        constructor.setAccessible(true);

        HungrySingleton hungrySingleton = HungrySingleton.getInstance();

        HungrySingleton newInstance = (HungrySingleton) constructor.newInstance();
        System.out.println(hungrySingleton == newInstance);
    }

    public void testSerialize() throws Exception {
        HungrySingleton hungrySingleton = HungrySingleton.getInstance();
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("singletonFile"));
        oos.writeObject(hungrySingleton);
        File file = new File("singletonFile");
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        HungrySingleton newInstance = (HungrySingleton) ois.readObject();
        System.out.println(newInstance);
        System.out.println(hungrySingleton);
        System.out.println(hungrySingleton == newInstance);
    }

    public static void testLazySingleton() {
        Thread t1 = new Thread(new T());
        Thread t2 = new Thread(new T());
        t1.start();
        t2.start();
        System.out.println("program end");
    }
}
