package memento;

/**
 * @author HT
 * @version V1.0
 * @package memento
 * @date 2019-05-10 10:26
 */
public class Main {

    public static void main(String[] args) {
        GameRole gameRole = new GameRole();
        gameRole.setInitState();
        gameRole.stateDisplay();

//        保存进度
        RoleStateCaretaker roleStateCaretaker = new RoleStateCaretaker();
        roleStateCaretaker.setMemento(gameRole.saveState());

        gameRole.fight();
        gameRole.stateDisplay();

        gameRole.recoveryState(roleStateCaretaker.getMemento());
        gameRole.stateDisplay();
    }
}
