package structural.bridge;

/**
 * @author HT
 * @version V1.0
 * @package structural.bridge
 * @date 2019-06-26 23:31
 */
public class Test {
    public static void main(String[] args) {
        Bank icbcBank = new ICBCBank(new DepositAccount());
        Account icbcAccount = icbcBank.openAccount();
        icbcAccount.showAccountType();

        Bank abcBank = new ABCBank(new SavingAccount());
        Account abcAccount = abcBank.openAccount();
        abcAccount.showAccountType();

    }
}
