package abstractfactory_update_update;

/**
 * @author HT
 * @version V1.0
 * @package abstractfactory_update
 * @date 2019-05-09 16:17
 */
public class DataAccess {
    private static final String db = "Access";

    public static IUser createUser() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        IUser result = null;
        Class clazz = Class.forName("abstractfactory_update_update." + db + "User");
        result = (IUser) clazz.newInstance();
        return result;
    }

    public static IDepartment createDepartment() throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        IDepartment result = null;
        Class clazz = Class.forName("abstractfactory_update_update." + db + "Department");
        result = (IDepartment) clazz.newInstance();
        return result;
    }
}
