package structural.decorator.v1;

/**
 * @author HT
 * @version V1.0
 * @package structural.decorator.v1
 * @date 2019-06-23 13:23
 */
public class BatterCakeWithEgg extends BatterCake {
    @Override
    public String getDesc() {
        return super.getDesc() + "加一个鸡蛋";
    }

    @Override
    public int cost() {
        return super.cost() + 1;
    }
}
