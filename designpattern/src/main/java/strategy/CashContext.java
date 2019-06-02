package strategy;

import strategy.CashStrategy.*;

/**
 * @author HT
 * @version V1.0
 * @package strategy
 * @date 2019-04-23 10:59
 */
public class CashContext {
    private CashSuper cashSuper;

    public CashContext(CashStrategy cashStrategy) {
        switch (cashStrategy) {
            case NORMAL:
                this.cashSuper = new CashNormal();
                break;
            case REBATE:
                this.cashSuper = new CashRebate(0.8d);
                break;
            default:
                this.cashSuper = new CashReturn(300, 100);
        }
    }

    public double getResult(double money) {
        return cashSuper.acceptCash(money);
    }
}
