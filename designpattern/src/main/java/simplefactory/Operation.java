package simplefactory;

/**
 * @author HT
 * @version V1.0
 * @package simplefactory
 * @date 2019-04-22 22:51
 */
public abstract class Operation {
    public double numberA = 0;

    public double numberB = 0;

    public Operation() {}

    public Operation(double numberA, double numberB) {
        this.numberA = numberA;
        this.numberB = numberB;
    }

    /**
     * 返回结果
     * @return
     */
    abstract double getResult();
}
