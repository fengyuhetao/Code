package visitor;

/**
 * @author HT
 * @version V1.0
 * @package visitor
 * @date 2019-05-12 21:15
 */
public class Failing extends Action {
    @Override
    public void getManConclusion(Man concreteElement) {
        System.out.println(String.format("%s %s 时，闷头喝酒，谁都不用劝", concreteElement.getClass().getName(), this.getClass().getName()));
    }

    @Override
    public void getWomanConclusion(Woman concreteElement) {
        System.out.println(String.format("%s %s 时，眼泪汪汪，谁也劝不了", concreteElement.getClass().getName(), this.getClass().getName()));
    }
}
