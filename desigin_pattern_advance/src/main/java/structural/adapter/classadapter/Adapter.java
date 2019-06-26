package structural.adapter.classadapter;

/**
 * @author HT
 * @version V1.0
 * @package structural.adapter.classadapter
 * @date 2019-06-23 16:54
 */
public class Adapter extends Adaptee implements Target {
    @Override
    public void request() {
        super.adapteeRequest();
    }
}
