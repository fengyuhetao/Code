package abstractfactory_update;

import abstractfactory.*;
import org.omg.CORBA.INTERNAL;

/**
 * @author HT
 * @version V1.0
 * @package abstractfactory_update
 * @date 2019-05-09 16:17
 */
public class DataAccess {
    /**
     * 1 表示sqlserver
     */
    private static final Integer db = 1;

    public static IUser createUser() {
        IUser result = null;
        switch (db){
            case 1:
                result = new SqlserverUser();
                break;
            case 2:
                result = new AccessUser();
                break;
            default:
                break;
        }
        return result;
    }

    public static IDepartment createDepartment() {
        IDepartment result = null;
        switch (db){
            case 1:
                result = new SqlserverDepartment();
                break;
            case 2:
                result = new AccessDepartment();
                break;
            default:
                break;
        }
        return result;
    }
}
