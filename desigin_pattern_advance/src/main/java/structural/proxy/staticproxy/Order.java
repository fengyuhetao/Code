package structural.proxy.staticproxy;

/**
 * @author HT
 * @version V1.0
 * @package structural.proxy
 * @date 2019-07-02 21:25
 */
public class Order {
    private Object orderInfo;

    private Integer userId;

    public Object getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(Object orderInfo) {
        this.orderInfo = orderInfo;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
