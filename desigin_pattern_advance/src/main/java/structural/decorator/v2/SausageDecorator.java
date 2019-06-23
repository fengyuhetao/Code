package structural.decorator.v2;

/**
 * @author HT
 * @version V1.0
 * @package structural.decorator.v2
 * @date 2019-06-23 13:33
 */
public class SausageDecorator extends AbstractDecorator {
    public SausageDecorator(ABatterCake aBatterCake) {
        super(aBatterCake);
    }

    @Override
    public void doSomething() {

    }

    @Override
    public String getDesc() {
        return super.getDesc() + "加一根香肠";
    }

    @Override
    public int cost() {
        return super.cost() + 2;
    }
}
