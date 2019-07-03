package structural.proxy.staticproxy;

import structural.proxy.db.DataSourceContextHolder;

/**
 * @author HT
 * @version V1.0
 * @package structural.proxy
 * @date 2019-07-02 21:31
 */
public class OrderServiceStaticProxy {
    private IOrderService iOrderService;

    public int saveOrder(Order order) {
        beforeMethod(order);
        iOrderService = new OrderServiceImpl();
        int result = iOrderService.saveOrder(order);
        afterMethod();
        return result;
    }

    private void beforeMethod(Order order) {
        int userId = order.getUserId();
        int dbRouter = userId % 2;
        System.out.println("静态代理分配到dbRouter" + dbRouter + " 处理数据");
        DataSourceContextHolder.setDBType(String.valueOf(dbRouter));
        System.out.println("静态代理 before code");
    }

    private void afterMethod() {
        System.out.println("静态代理 after code");
    }
}
