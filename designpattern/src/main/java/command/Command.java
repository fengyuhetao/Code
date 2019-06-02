package command;

/**
 * @author HT
 * @version V1.0
 * @package command
 * @date 2019-05-11 10:21
 */
public abstract class Command {
    protected Barbecuer receiver;

    public Command(Barbecuer receiver) {
        this.receiver = receiver;
    }

    abstract public void executeCommand();
}
