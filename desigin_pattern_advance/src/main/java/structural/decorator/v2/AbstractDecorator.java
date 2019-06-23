package structural.decorator.v2;

import lombok.AllArgsConstructor;
import lombok.Setter;

/**
 * @author HT
 * @version V1.0
 * @package structural.decorator.v2
 * @date 2019-06-23 13:32
 */
@AllArgsConstructor
@Setter
public abstract class AbstractDecorator extends ABatterCake {
    private ABatterCake aBatterCake;

    public abstract void doSomething();

    @Override
    public String getDesc() {
        return this.aBatterCake.getDesc();
    }

    @Override
    public int cost() {
        return this.aBatterCake.cost();
    }
}
