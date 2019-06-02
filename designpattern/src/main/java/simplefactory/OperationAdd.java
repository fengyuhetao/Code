package simplefactory;

/**
 * @author HT
 * @version V1.0
 * @package simplefactory
 * @date 2019-04-22 22:53
 */
public class OperationAdd extends Operation {

    public OperationAdd(){
        super();
    }

    public OperationAdd(double numberA, double numberB) {
        super(numberA, numberB);
    }

    @Override
    double getResult() {
        return this.numberA + this.numberB;
    }
}
