package adapter;

/**
 * 外籍中锋
 *
 * @author HT
 * @version V1.0
 * @package adapter
 * @date 2019-05-10 09:58
 */
public class ForeignCenter {
    private String name;

    public ForeignCenter() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void ForeignCenterAttack() {
        System.out.println("外籍中锋" + name + "进攻");
    }

    public void ForeignCenterDefense() {
        System.out.println("外籍中锋" + name + "防守");
    }
}
