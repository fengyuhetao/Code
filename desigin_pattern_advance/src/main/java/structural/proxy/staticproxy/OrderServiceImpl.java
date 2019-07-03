package structural.proxy.staticproxy;

/**
 * @author HT
 * @version V1.0
 * @package structural.proxy
 * @date 2019-07-02 21:28
 */
public class OrderServiceImpl implements IOrderService {
    private IOrderDao iOrderDao;

    @Override
    public int saveOrder(Order order) {
        // spring会自己注入
        iOrderDao = new OrderDaoImpl();
        System.out.println("Service层调用Dao层添加Order");
        return iOrderDao.insert(order);
    }
}
