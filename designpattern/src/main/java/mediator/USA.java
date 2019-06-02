package mediator;

/**
 * @author HT
 * @version V1.0
 * @package mediator
 * @date 2019-05-11 16:11
 */
public class USA extends Country {
    public USA(UnitedNations unitedNations) {
        super(unitedNations);
    }

    public void declare(String message) {
        mediator.declare(message, this);
    }

    public void getMessage(String message) {
        System.out.println("美国或得对方信息:" + message);
    }
}
