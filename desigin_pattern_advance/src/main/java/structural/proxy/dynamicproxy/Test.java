package structural.proxy.dynamicproxy;

import structural.proxy.staticproxy.IOrderService;
import structural.proxy.staticproxy.Order;
import structural.proxy.staticproxy.OrderServiceImpl;

/**
 * @author HT
 * @version V1.0
 * @package structural.proxy.dynamicproxy
 * @date 2019-07-04 00:42
 */
public class Test {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        Order order = new Order();
        order.setUserId(1);
        IOrderService orderService = (IOrderService) new OrderServiceDynamicProxy(new OrderServiceImpl()).bind();
        orderService.saveOrder(order);

    }
}
