package structural.proxy.db;

/**
 * @author HT
 * @version V1.0
 * @package structural.proxy.db
 * @date 2019-07-02 21:34
 */
public class DataSourceContextHolder {
    private static final ThreadLocal<String>  CONTEXT_HOLDER = new ThreadLocal<>();

    public static void setDBType(String dbType) {
        CONTEXT_HOLDER.set(dbType);
    }

    public static String getDBType() {
        return CONTEXT_HOLDER.get();
    }

    public static void clearDBType() {
        CONTEXT_HOLDER.remove();
    }
}
