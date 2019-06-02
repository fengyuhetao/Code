package command;

/**
 * @author HT
 * @version V1.0
 * @package command
 * @date 2019-05-11 10:23
 */
public class BakeMuttonCommand extends Command {
    public BakeMuttonCommand(Barbecuer receiver) {
        super(receiver);
    }

    @Override
    public void executeCommand() {
        receiver.BakeMutton();
    }
}
