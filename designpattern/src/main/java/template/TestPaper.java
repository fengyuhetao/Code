package template;

/**
 * @author HT
 * @version V1.0
 * @package template
 * @date 2019-05-08 22:17
 */
public abstract class TestPaper {
    public void TestQuestion1() {
        System.out.println("杨过");
        System.out.println("答案:" + Answer1());
    }

    public void TestQuestion2() {
        System.out.println("小龙女");
        System.out.println("答案:" + Answer2());
    }

    public void TestQuestion3() {
        System.out.println("郭襄");
        System.out.println("答案:" + Answer3());
    }

    protected abstract String Answer1();

    protected abstract String Answer2();

    protected abstract String Answer3();
}
