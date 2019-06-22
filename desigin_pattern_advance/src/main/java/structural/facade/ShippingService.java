package structural.facade;

/**
 * @author HT
 * @version V1.0
 * @package structural.facade
 * @date 2019-06-22 22:57
 */
public class ShippingService {
    public String shipGift(PointsGift pointsGift) {
        //物流系统对接逻辑
        System.out.println("进入物流" +pointsGift.getName());
        String shippingOrderNo = "666";
        return shippingOrderNo;
    }
}
