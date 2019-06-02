package facade;

/**
 * @author HT
 * @version V1.0
 * @package facade
 * @date 2019-05-09 09:03
 */
public class Fund {
    Stock1 stock1;
    Stock2 stock2;
    Realty realty;

    public Fund() {
        stock1 = new Stock1();
        stock2 = new Stock2();
        realty = new Realty();
    }

    public void BuyFund() {
        stock1.buy();
        stock2.buy();
        realty.buy();
    }

    public void SellFund() {
        stock1.sell();
        stock2.sell();
        realty.sell();
    }
}
