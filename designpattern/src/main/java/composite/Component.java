package composite;

/**
 * @author HT
 * @version V1.0
 * @package composite
 * @date 2019-05-10 11:25
 */
public abstract class Component {
    protected String name;

    public Component(String name) {
        this.name = name;
    }

    public abstract void Add(Component component);

    public abstract void Remove(Component component);

    public abstract void Display(int depth);
}
