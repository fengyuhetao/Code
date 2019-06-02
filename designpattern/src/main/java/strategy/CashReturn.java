package strategy;

/**
 * 返利收费
 *
 * @author HT
 * @version V1.0
 * @package strategy
 * @date 2019-04-23 11:00
 */
public class CashReturn extends CashSuper {
    private double moneyCondition = 0.0d;

    private double moneyReturn = 0.0d;

    public CashReturn() {

    }

    public CashReturn(double moneyCondition, double moneyReturn) {
        this.moneyCondition = moneyCondition;
        this.moneyReturn = moneyReturn;
    }

    @Override
    public double acceptCash(double money) {
        double result = money;
        if(money >= moneyCondition) {
            result = money - Math.floor(money / moneyCondition) * moneyReturn;
        }
        return result;
    }
}
