package factory;

/**
 * @author HT
 * @version V1.0
 * @package factory
 * @date 2019-05-08 15:29
 */
public class SimpleFactory {
    public static LeiFeng createLeiFeng(Integer type) {
        LeiFeng leiFeng = null;
        switch (type) {
            case 1:
                leiFeng = new UnderGraduate();
                break;
            case 2:
                leiFeng = new Volunteer();
                break;
            default:
                break;
        }

        return leiFeng;
    }
}
