package abstractfactory;

/**
 * @author HT
 * @version V1.0
 * @package abstractfactory
 * @date 2019-05-09 16:03
 */
public class AccessFactory implements IFactory {
    @Override
    public IUser createUser() {
        return new AccessUser();
    }

    @Override
    public IDepartment createDepartment() {
        return new AccessDepartment();
    }
}
