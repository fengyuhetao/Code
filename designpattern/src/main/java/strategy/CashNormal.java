package strategy;

/**
 * 打折收费
 *
 * @author HT
 * @version V1.0
 * @package strategy
 * @date 2019-04-23 11:00
 */
public class CashNormal extends CashSuper {

    @Override
    public double acceptCash(double money) {
        return money;
    }
}
