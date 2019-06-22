package structural.facade;

/**
 * @author HT
 * @version V1.0
 * @package creational.facade
 * @date 2019-06-22 22:44
 */
public class Test {
    public static void main(String[] args) {
        PointsGift pointsGift = new PointsGift("鞋子");
        GiftExchangeService giftExchangeService = new GiftExchangeService();

        giftExchangeService.setPointsPaymentService(new PointsPaymentService());
        giftExchangeService.setQualifyService(new QualifyService());
        giftExchangeService.setShippingService(new ShippingService());
        giftExchangeService.giftExchange(pointsGift);
    }
}
