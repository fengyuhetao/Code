package composite;

/**
 * @author HT
 * @version V1.0
 * @package composite
 * @date 2019-05-10 11:26
 */
public class Leaf extends Component {
    public Leaf(String name) {
        super(name);
    }

    @Override
    public void Add(Component component) {
        System.out.println("cannot add to a leaf");
    }

    @Override
    public void Remove(Component component) {
        System.out.println("cannot remove from a leaf");
    }

    @Override
    public void Display(int depth) {
        System.out.println(new String(new char[depth]).replace("\0", "-") + name);
    }
}
