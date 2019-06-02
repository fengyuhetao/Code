package memento;

/**
 * @author HT
 * @version V1.0
 * @package memento
 * @date 2019-05-10 10:23
 */
public class RoleStateMemento {
    private Integer vit;

    private Integer attack;

    private Integer defense;

    public RoleStateMemento(Integer vit, Integer attack, Integer defense) {
        this.vit = vit;
        this.attack = attack;
        this.defense = defense;
    }

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

    public Integer getDefense() {
        return defense;
    }

    public void setDefense(Integer defense) {
        this.defense = defense;
    }
}
