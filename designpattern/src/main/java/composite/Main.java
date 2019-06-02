package composite;

/**
 * @author HT
 * @version V1.0
 * @package composite
 * @date 2019-05-10 11:31
 */
public class Main {
    public static void main(String[] args) {
        Composite root = new Composite("root");
        root.Add(new Leaf("Leaf A"));

        Composite composite = new Composite("Composite A");
        root.Add(composite);

        composite.Add(new Leaf("Leaf B"));
        root.Display(1);
    }
}
