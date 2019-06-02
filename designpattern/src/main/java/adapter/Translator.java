package adapter;

/**
 * @author HT
 * @version V1.0
 * @package adapter
 * @date 2019-05-10 10:02
 */
public class Translator extends Player {
    private ForeignCenter foreignCenter = new ForeignCenter();

    public Translator(String name) {
        super(name);
        foreignCenter.setName(name);
    }


    @Override
    public void Attack() {
        foreignCenter.ForeignCenterAttack();
    }

    @Override
    public void Defense() {
        foreignCenter.ForeignCenterDefense();

    }
}
