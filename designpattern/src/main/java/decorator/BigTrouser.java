package decorator;

/**
 * 装饰类
 * Created by hetao on 2019/4/24.
 */
public class BigTrouser extends Finery{
    public BigTrouser() {}

    @Override
    public void show() {
        System.out.println("裤子");
        super.show();
    }
}
