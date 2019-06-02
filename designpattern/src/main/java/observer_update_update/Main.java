package observer_update_update;

import java.lang.reflect.InvocationTargetException;

/**
 * @author HT
 * @version V1.0
 * @package observer
 * @date 2019-05-09 11:03
 */
public class Main {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Subject subject = new Boss();
        NBAObserver nbaObserver = new NBAObserver("甲");
        StockObserver stockObserver = new StockObserver("乙");

        subject.addListener(nbaObserver, "closeNBADirectSeeding", "老板回来了");
        subject.addListener(stockObserver, "closeStockMarket", "老板回来了");

        subject.notifyObserver();
    }
}
