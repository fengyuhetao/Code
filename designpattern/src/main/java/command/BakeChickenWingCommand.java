package command;

/**
 * @author HT
 * @version V1.0
 * @package command
 * @date 2019-05-11 10:23
 */
public class BakeChickenWingCommand extends Command {
    public BakeChickenWingCommand(Barbecuer receiver) {
        super(receiver);
    }

    @Override
    public void executeCommand() {
        receiver.BakeChickenWing();
    }
}
