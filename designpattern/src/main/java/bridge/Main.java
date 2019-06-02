package bridge;

/**
 * @author HT
 * @version V1.0
 * @package bridge
 * @date 2019-05-11 10:06
 */
public class Main {
    public static void main(String[] args) {
        HandsetBrand handsetBrand;

        handsetBrand = new HandsetBrandM();
        handsetBrand.setHandsetSoft(new HandsetGame());
        handsetBrand.run();

        handsetBrand.setHandsetSoft(new HandsetAddressList());
        handsetBrand.run();
    }
}
