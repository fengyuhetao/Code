package structural.proxy.staticproxy;

/**
 * @author HT
 * @version V1.0
 * @package structural.proxy
 * @date 2019-07-02 21:27
 */
public class OrderDaoImpl implements IOrderDao {
    @Override
    public int insert(Order order) {
        System.out.printf("Dao层添加order成功");
        return 1;
    }
}
