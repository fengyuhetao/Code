package structural.decorator.v1;

/**
 * @author HT
 * @version V1.0
 * @package structural.decorator.v1
 * @date 2019-06-23 13:24
 */
public class BatterCakeWithEggSausage extends BatterCakeWithEgg{
    @Override
    public String getDesc() {
        return super.getDesc() + "加一个香肠";
    }

    @Override
    public int cost() {
        return super.cost() + 2;
    }
}
