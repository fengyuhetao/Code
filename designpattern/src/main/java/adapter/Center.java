package adapter;

/**
 * 中锋
 *
 * @author HT
 * @version V1.0
 * @package adapter
 * @date 2019-05-10 09:58
 */
public class Center extends Player {
    public Center(String name) {
        super(name);
    }

    @Override
    public void Attack() {
        System.out.println("中锋" + name + "进攻");
    }

    @Override
    public void Defense() {
        System.out.println("中锋" + name + "防守");
    }
}
