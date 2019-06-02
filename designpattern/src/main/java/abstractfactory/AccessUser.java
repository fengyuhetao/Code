package abstractfactory;

/**
 * @author HT
 * @version V1.0
 * @package abstractfactory
 * @date 2019-05-09 16:01
 */
public class AccessUser implements IUser {
    @Override
    public void insert(User user) {
        System.out.println("在access中插入一条user记录");
    }

    @Override
    public void getUser(int id) {
        System.out.println("在access中获取id为" + id + "的记录");
    }
}
