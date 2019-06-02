package composite;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author HT
 * @version V1.0
 * @package composite
 * @date 2019-05-10 11:29
 */
public class Composite extends Component{
    private List<Component> children = new ArrayList<Component>();

    public Composite(String name) {
        super(name);
    }

    @Override
    public void Add(Component component) {
        children.add(component);
    }

    @Override
    public void Remove(Component component) {
        children.remove(component);
    }

    @Override
    public void Display(int depth) {
        System.out.println(new String(new char[depth]).replace("\0", "-") + name);
        for(Component component: children) {
            component.Display(depth + 2);
        }
    }
}
