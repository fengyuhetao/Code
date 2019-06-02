package visitor;

/**
 * @author HT
 * @version V1.0
 * @package visitor
 * @date 2019-05-12 21:14
 */
public abstract class Action {
    public abstract void getManConclusion(Man concreteElement);

    public abstract void getWomanConclusion(Woman concreteElement);
}
