package structural.adapter.objectadapter;

import structural.adapter.classadapter.Target;

/**
 * @author HT
 * @version V1.0
 * @package structural.adapter.classadapter
 * @date 2019-06-23 16:53
 */
public class ConcreteTarget implements Target {
    @Override
    public void request() {
        System.out.println("concreateTarget目标方法");
    }
}
