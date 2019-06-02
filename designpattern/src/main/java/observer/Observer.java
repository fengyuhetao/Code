package observer;

/**
 * @author HT
 * @version V1.0
 * @package observer
 * @date 2019-05-09 10:44
 */
public abstract class Observer {
    protected String name;

    protected Subject subject;

    public Observer(String name, Subject subject) {
        this.name = name;
        this.subject = subject;
    }

    public abstract void update();
}
