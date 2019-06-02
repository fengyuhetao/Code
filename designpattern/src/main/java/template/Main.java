package template;

/**
 * @author HT
 * @version V1.0
 * @package template
 * @date 2019-05-08 22:22
 */
public class Main {
    public static void main(String[] args) {
        TestPaper studentA = new TestPagerA();
        studentA.TestQuestion1();
        studentA.TestQuestion2();

        TestPaper studentB = new TestPagerB();
        studentB.TestQuestion1();
        studentB.TestQuestion2();
    }
}
