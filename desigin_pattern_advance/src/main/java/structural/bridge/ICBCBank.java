package structural.bridge;

/**
 * @author HT
 * @version V1.0
 * @package structural.bridge
 * @date 2019-06-26 23:51
 */
public class ICBCBank extends Bank {
    public ICBCBank(Account account) {
        super(account);
    }

    @Override
    Account openAccount() {
        System.out.println("打开工商银行账号");
        account.openAccount();
        return account;
    }
}
