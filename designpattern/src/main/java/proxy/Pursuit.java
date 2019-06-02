package proxy;

/**
 * Created by hetao on 2019/4/25.
 */
public class Pursuit implements GiveGift {
    SchoolGirl schoolGirl;

    public Pursuit(SchoolGirl schoolGirl) {
        this.schoolGirl = schoolGirl;
    }

    @Override
    public void GiveDolls() {
        System.out.println("送" + schoolGirl.getName() + "洋娃娃");
    }

    @Override
    public void GiveFlowers() {
        System.out.println("送" + schoolGirl.getName() + "花");

    }

    @Override
    public void GiveChocolate() {
        System.out.println("送" + schoolGirl.getName() + "巧克力");
    }
}
