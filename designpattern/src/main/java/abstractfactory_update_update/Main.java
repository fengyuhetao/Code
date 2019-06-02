package abstractfactory_update_update;

/**
 * @author HT
 * @version V1.0
 * @package abstractfactory
 * @date 2019-05-09 16:03
 */
public class Main {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        User user = new User();

        IUser iu = DataAccess.createUser();

        iu.insert(user);
        iu.getUser(1);

        Department department = new Department();
        IDepartment iDepartment = DataAccess.createDepartment();
        iDepartment.insert(department);
        iDepartment.getDepartment(1);
    }
}
