package structural.decorator.v2;

/**
 * @author HT
 * @version V1.0
 * @package structural.decorator.v2
 * @date 2019-06-23 13:31
 */
public class BatterCake extends ABatterCake{
    @Override
    public String getDesc() {
        return "煎饼";
    }

    @Override
    public int cost() {
        return 8;
    }
}
