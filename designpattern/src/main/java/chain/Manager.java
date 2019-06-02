package chain;

/**
 * @author HT
 * @version V1.0
 * @package chain
 * @date 2019-05-11 12:01
 */
public abstract class Manager {
    protected String name;

    protected Manager superior;

    public Manager(String name) {
        this.name = name;
    }

    public void setSuperior(Manager superior) {
        this.superior = superior;
    }

    abstract public void requestApplication(Request request);

}
