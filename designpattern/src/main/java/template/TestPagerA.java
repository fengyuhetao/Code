package template;

/**
 * 学生甲的答卷
 *
 * @author HT
 * @version V1.0
 * @package template
 * @date 2019-05-08 22:18
 */
public class TestPagerA extends TestPaper {
    @Override
    protected String Answer1() {
        return "a";
    }

    @Override
    protected String Answer2() {
        return "b";
    }

    @Override
    protected String Answer3() {
        return "c";
    }
}
