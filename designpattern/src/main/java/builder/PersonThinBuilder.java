package builder;

/**
 * @author HT
 * @version V1.0
 * @package builder
 * @date 2019-05-09 09:21
 */
public class PersonThinBuilder implements PersonBuilder {
    @Override
    public void buildhead() {
        System.out.println("创建头");
    }

    @Override
    public void buildbody() {
        System.out.println("创建瘦瘦的身体");
    }

    @Override
    public void buildarmleft() {
        System.out.println("创建左手");
    }

    @Override
    public void buildarmright() {
        System.out.println("创建右手");
    }

    @Override
    public void buildlegleft() {
        System.out.println("创建左脚");
    }

    @Override
    public void buildlegright() {
        System.out.println("创建右脚");
    }
}
