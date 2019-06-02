package visitor;

/**
 * @author HT
 * @version V1.0
 * @package visitor
 * @date 2019-05-12 21:15
 */
public abstract class Person {
    public abstract void accept(Action visitor);
}
