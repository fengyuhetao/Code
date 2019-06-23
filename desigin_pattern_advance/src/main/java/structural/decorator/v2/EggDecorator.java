package structural.decorator.v2;

/**
 * @author HT
 * @version V1.0
 * @package structural.decorator.v2
 * @date 2019-06-23 13:33
 */
public class EggDecorator extends AbstractDecorator {
    public EggDecorator(ABatterCake aBatterCake) {
        super(aBatterCake);
    }

    @Override
    public void doSomething() {

    }

    @Override
    public String getDesc() {
        return super.getDesc() + "加一个鸡蛋";
    }

    @Override
    public int cost() {
        return super.cost() + 1;
    }
}
