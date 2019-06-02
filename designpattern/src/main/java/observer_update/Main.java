package observer_update;

/**
 * @author HT
 * @version V1.0
 * @package observer
 * @date 2019-05-09 11:03
 */
public class Main {
    public static void main(String[] args) {
        Subject subject = new Boss();
        NBAObserver nbaObserver = new NBAObserver("甲", subject);
        StockObserver stockObserver = new StockObserver("乙", subject);

        subject.setAction("老板我回来了");
        try {
            subject.update = nbaObserver.getClass().getMethod("closeNBADirectSeeding", new Class[] {String.class});
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        }

        subject.notifyObserver((Object)nbaObserver);

        try {
            subject.update = stockObserver.getClass().getMethod("closeStockMarket", new Class[] {String.class});
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        }

        subject.notifyObserver((Object)stockObserver);
    }
}
