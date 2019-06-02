package command;

/**
 * @author HT
 * @version V1.0
 * @package command
 * @date 2019-05-11 10:24
 */
public class Main {
    public static void main(String[] args) {
        Barbecuer barbecuer = new Barbecuer();
        Command command1 = new BakeMuttonCommand(barbecuer);
        Command command2 = new BakeChickenWingCommand(barbecuer);

        Waiter waiter = new Waiter();
        waiter.setOrder(command1);
        waiter.setOrder(command2);
        waiter.notifyBakecuer();

    }
}
