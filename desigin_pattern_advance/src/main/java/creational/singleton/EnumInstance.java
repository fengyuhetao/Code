package creational.singleton;

/**
 * @author HT
 * @version V1.0
 * @package creational.singleton
 * @date 2019-06-17 23:22
 */
public enum  EnumInstance {
    INSTANCE {
        protected void printTest() {
            System.out.println("hahah");
        }
    }
    ;
    protected abstract void printTest();

    private Object data;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static EnumInstance getInstance() {
        return INSTANCE;
    }
}
