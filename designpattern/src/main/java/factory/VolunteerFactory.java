package factory;

/**
 * @author HT
 * @version V1.0
 * @package factory
 * @date 2019-05-08 15:27
 */
public class VolunteerFactory implements IFactory {

    @Override
    public LeiFeng createLeiFeng() {
        return new Volunteer();
    }
}
