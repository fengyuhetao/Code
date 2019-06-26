package structural.bridge;

/**
 * @author HT
 * @version V1.0
 * @package structural.bridge
 * @date 2019-06-26 23:47
 */
public abstract class Bank {
    protected Account account;

    public Bank(Account account) {
        this.account = account;
    }

    abstract Account openAccount();
}