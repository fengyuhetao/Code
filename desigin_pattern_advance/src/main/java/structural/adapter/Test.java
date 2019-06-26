package structural.adapter;

import structural.adapter.classadapter.Adapter;
import structural.adapter.classadapter.ConcreteTarget;
import structural.adapter.classadapter.Target;

/**
 * @author HT
 * @version V1.0
 * @package structural.Adapter
 * @date 2019-06-23 16:51
 */
public class Test {
    public static void main(String[] args) {
        testPower();
    }

    public static void testClass(){
        Target target = new ConcreteTarget();
        target.request();

        Target adapterTarget = new Adapter();
        adapterTarget.request();
    }

    public static void testPower() {
        DC5 dc5 = new PowerAdapter();
        dc5.outputDC5V();
    }
}
