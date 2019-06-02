package mediator;

/**
 * @author HT
 * @version V1.0
 * @package mediator
 * @date 2019-05-11 16:12
 */
public class Iraq extends Country {
    public Iraq(UnitedNations unitedNations) {
        super(unitedNations);
    }

    public void declare(String message) {
        mediator.declare(message, this);
    }

    public void getMessage(String message) {
        System.out.println("伊拉克获得对方信息: " + message);
    }
}
