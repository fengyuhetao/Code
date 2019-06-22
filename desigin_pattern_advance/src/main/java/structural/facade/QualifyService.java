package structural.facade;

/**
 * @author HT
 * @version V1.0
 * @package structural.facade
 * @date 2019-06-22 22:56
 */
public class QualifyService {
    public boolean isAvailable(PointsGift pointsGift) {
        System.out.println("校验" + pointsGift.getName() + "积分资格通过，库存公国");
        return true;
    }
}
