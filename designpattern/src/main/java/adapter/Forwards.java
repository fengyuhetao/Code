package adapter;

/**
 * 前锋
 *
 * @author HT
 * @version V1.0
 * @package adapter
 * @date 2019-05-10 09:58
 */
public class Forwards extends Player {
    public Forwards(String name) {
        super(name);
    }

    @Override
    public void Attack() {
        System.out.println("前锋" + name + "进攻");
    }

    @Override
    public void Defense() {
        System.out.println("前锋" + name + "防守");
    }
}
