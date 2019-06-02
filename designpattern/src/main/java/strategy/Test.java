package strategy;

/**
 * @author HT
 * @version V1.0
 * @package strategy
 * @date 2019-04-23 11:16
 *
 * 测试策略模式
 */
public class Test {
    public static void main(String [] args) {
        CashContext cashContext = new CashContext(CashStrategy.REBATE);
        double money = cashContext.getResult(200);
        System.out.println(money);
    }
}
