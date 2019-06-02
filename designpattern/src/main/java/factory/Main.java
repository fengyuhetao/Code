package factory;

/**
 * @author HT
 * @version V1.0
 * @package factory
 * @date 2019-05-08 15:23
 */
public class Main {
    public static void main(String[] args) {
        IFactory factory = new UnderGraduateFactory();
        LeiFeng student = factory.createLeiFeng();
        student.sweep();

        LeiFeng studentA = SimpleFactory.createLeiFeng(1);
        studentA.sweep();
    }
}
