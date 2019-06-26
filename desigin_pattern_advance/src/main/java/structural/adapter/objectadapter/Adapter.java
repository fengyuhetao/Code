package structural.adapter.objectadapter;

/**
 * @author HT
 * @version V1.0
 * @package structural.adapter.objectadapter
 * @date 2019-06-23 16:59
 */
public class Adapter implements Target {
    private Adaptee adaptee = new Adaptee();

    @Override
    public void request() {
        adaptee.adapteeRequest();
    }
}
