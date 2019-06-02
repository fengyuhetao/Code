package memento;

import javax.management.relation.Role;

/**
 * @author HT
 * @version V1.0
 * @package memento
 * @date 2019-05-10 10:20
 */
public class GameRole {
    private Integer vit;

    private Integer attack;

    private int defense;

    public Integer getVit() {
        return vit;
    }

    public void setVit(Integer vit) {
        this.vit = vit;
    }

    public Integer getAttack() {
        return attack;
    }

    public void setAttack(Integer attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public void stateDisplay() {
        System.out.println("角色当前状态");
        System.out.println(vit);
        System.out.println(attack);
        System.out.println(defense);
    }

    public void setInitState() {
        this.vit = 100;
        this.attack = 100;
        this.defense = 100;
    }

    public void fight() {
        this.vit = 0;
        this.attack = 0;
        this.defense = 0;
    }

    public RoleStateMemento saveState() {
        return new RoleStateMemento(this.vit, this.attack, this.defense);
    }

    public void recoveryState(RoleStateMemento memento) {
        this.vit = memento.getVit();
        this.attack = memento.getAttack();
        this.defense = memento.getDefense();
    }
}
