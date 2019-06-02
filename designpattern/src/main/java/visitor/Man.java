package visitor;

/**
 * @author HT
 * @version V1.0
 * @package visitor
 * @date 2019-05-12 21:17
 */
public class Man extends Person {
    @Override
    public void accept(Action visitor) {
        visitor.getManConclusion(this);
    }
}
