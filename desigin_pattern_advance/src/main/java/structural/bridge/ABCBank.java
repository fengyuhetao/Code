package structural.bridge;

/**
 * @author HT
 * @version V1.0
 * @package structural.bridge
 * @date 2019-06-26 23:50
 */
public class ABCBank extends Bank {
    public ABCBank(Account account) {
        super(account);
    }

    @Override
    Account openAccount() {
        System.out.println("打开中国农业银行账号");
        account.openAccount();
        return account;
    }
}
