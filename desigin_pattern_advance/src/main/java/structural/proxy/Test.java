package structural.proxy;

import structural.proxy.staticproxy.Order;
import structural.proxy.staticproxy.OrderServiceStaticProxy;

/**
 * @author HT
 * @version V1.0
 * @package structural.proxy
 * @date 2019-07-02 23:51
 */
public class Test {
    public static void main(String[] args) {
        Order order = new Order();
        order.setUserId(1);
        OrderServiceStaticProxy orderServiceStaticProxy = new OrderServiceStaticProxy();
        orderServiceStaticProxy.saveOrder(order);
    }
}
