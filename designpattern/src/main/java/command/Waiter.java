package command;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author HT
 * @version V1.0
 * @package command
 * @date 2019-05-11 10:24
 */
public class Waiter {
    private List<Command> commands = new ArrayList<Command>();

    public void setOrder(Command command) {
        if(command.toString().startsWith("command.BakeChickenWingCommand")) {
            System.out.println("服务员:鸡翅没了");
        } else {
            commands.add(command);
            System.out.println("增加订单:" + command.toString() + " 时间:" + new Date());
        }
    }

    public void cancelOrder(Command command) {
        commands.remove(command);
        System.out.println("取消订单:" + command.toString() + " 时间:" + new Date());
    }

    public void notifyBakecuer() {
        for(Command command: commands) {
            command.executeCommand();
        }
    }
}
