package adapter;

/**
 * @author HT
 * @version V1.0
 * @package adapter
 * @date 2019-05-10 09:57
 */
public abstract class Player {
    protected String name;

    public Player(String name) {
        this.name = name;
    }

    public abstract void Attack();

    public abstract void Defense();
}
