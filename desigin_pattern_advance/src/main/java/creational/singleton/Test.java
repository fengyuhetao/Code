package creational.singleton;

/**
 * @author HT
 * @version V1.0
 * @package creational.singleton
 * @date 2019-06-15 23:30
 */
public class Test {
    public static void main(String[] args) {

    }

    public void testLazySingleton() {
        Thread t1 = new Thread(new T());
        Thread t2 = new Thread(new T());
        t1.start();
        t2.start();
        System.out.println("program end");
    }
}
