package memento;

/**
 * @author HT
 * @version V1.0
 * @package memento
 * @date 2019-05-10 10:26
 */
public class RoleStateCaretaker {
    private RoleStateMemento memento;

    public RoleStateMemento getMemento() {
        return memento;
    }

    public void setMemento(RoleStateMemento memento) {
        this.memento = memento;
    }
}
