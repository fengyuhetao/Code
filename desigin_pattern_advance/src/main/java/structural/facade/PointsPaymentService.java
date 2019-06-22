package structural.facade;

/**
 * @author HT
 * @version V1.0
 * @package structural.facade
 * @date 2019-06-22 22:57
 */
public class PointsPaymentService {
    public boolean pay(PointsGift pointsGift) {
        // 扣减积分
        System.out.println("支付" + pointsGift.getName() + "积分成功");
        return true;
    }
}
