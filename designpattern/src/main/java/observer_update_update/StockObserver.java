package observer_update_update;

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

    public StockObserver(String name) {
        this.name = name;
    }

    public void closeStockMarket(String action) {
        System.out.println(action + ", " + name + " 关闭股票行情，继续工作");
    }
}
