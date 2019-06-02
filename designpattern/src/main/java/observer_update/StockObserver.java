package observer_update;

/**
 * 看股票的人
 *
 * @author HT
 * @version V1.0
 * @package observer
 * @date 2019-05-09 10:49
 */
public class StockObserver {
    protected String name;

    protected Subject subject;

    public StockObserver(String name, Subject subject) {
        this.name = name;
        this.subject = subject;
    }

    public void closeStockMarket(String action) {
        System.out.println(action + ", " + name + " 关闭股票行情，继续工作");
    }
}
