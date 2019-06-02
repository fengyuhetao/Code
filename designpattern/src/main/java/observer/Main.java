package observer;

/**
 * @author HT
 * @version V1.0
 * @package observer
 * @date 2019-05-09 11:03
 */
public class Main {
    public static void main(String[] args) {
        Subject subject = new Secretary();
        StockObserver stockObserver = new StockObserver("甲", subject);
        NBAObserver nbaObserver = new NBAObserver("乙", subject);

        subject.attach(stockObserver);
        subject.attach(nbaObserver);

        subject.setAction("我回来了");

        subject.notifyObserver();
    }
}
