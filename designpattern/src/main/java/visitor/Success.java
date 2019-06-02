package visitor;

/**
 * @author HT
 * @version V1.0
 * @package visitor
 * @date 2019-05-12 21:15
 */
public class Success extends Action {
    @Override
    public void getManConclusion(Man concreteElement) {
        System.out.println(String.format("%s %s 时，背后多半有一个伟大的女人", concreteElement.getClass().getName(), this.getClass().getName()));
    }

    @Override
    public void getWomanConclusion(Woman concreteElement) {
        System.out.println(String.format("%s %s 时，背后多半有一个不成功的男人", concreteElement.getClass().getName(), this.getClass().getName()));
    }
}
