package strategy;

/**
 * 打折收费
 *
 * @author HT
 * @version V1.0
 * @package strategy
 * @date 2019-04-23 11:00
 */
public class CashRebate extends CashSuper {
    private double moneyRebate = 1d;

    public CashRebate() {

    }

    public CashRebate(double moenyRebate) {
        this.moneyRebate = moenyRebate;
    }

    @Override
    public double acceptCash(double money) {
        return money * this.moneyRebate;
    }
}
