package structural.facade;

import lombok.Setter;

/**
 * @author HT
 * @version V1.0
 * @package structural.facade
 * @date 2019-06-22 22:59
 */
@Setter
public class GiftExchangeService {
    private QualifyService qualifyService;

    private PointsPaymentService pointsPaymentService;

    private ShippingService shippingService;

    public void giftExchange(PointsGift pointsGift) {
        if(qualifyService.isAvailable(pointsGift)) {
            // 资格校验通过
            if(pointsPaymentService.pay(pointsGift)) {
//                支付积分成功
                String shippingOrderNo = shippingService.shipGift(pointsGift);
                System.out.println(shippingOrderNo);
            }
        }
    }
}
