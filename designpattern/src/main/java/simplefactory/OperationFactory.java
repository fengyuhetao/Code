package simplefactory;

/**
 * @author HT
 * @version V1.0
 * @package simplefactory
 * @date 2019-04-22 22:55
 */
public class OperationFactory {
    public static Operation createOperate(char operate) {
        Operation operation = null;
        switch (operate) {
            case '+':
                operation = new OperationAdd();
                break;
            default:
                break;
        }

        return operation;
    }
}
