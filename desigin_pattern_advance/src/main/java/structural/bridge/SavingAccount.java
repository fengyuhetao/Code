package structural.bridge;

/**
 * @author HT
 * @version V1.0
 * @package structural.bridge
 * @date 2019-06-26 23:45
 */
public class SavingAccount implements Account {
    @Override
    public Account openAccount() {
        System.out.println("打开火气状态");
        return new SavingAccount();
    }

    @Override
    public void showAccountType() {
        System.out.println("这是一个活期账号");
    }
}
