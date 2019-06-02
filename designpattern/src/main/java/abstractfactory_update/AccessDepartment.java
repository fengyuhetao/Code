package abstractfactory_update;

/**
 * @author HT
 * @version V1.0
 * @package abstractfactory
 * @date 2019-05-09 16:01
 */
public class AccessDepartment implements IDepartment {
    @Override
    public void insert(Department department) {
        System.out.println("在access中插入一条department记录");
    }

    @Override
    public void getDepartment(int id) {
        System.out.println("在access中获取id为" + id + "的记录");
    }
}
