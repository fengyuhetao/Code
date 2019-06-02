package decorator;

/**
 * Created by hetao on 2019/4/24.
 */
public class TShirts extends Finery{

    public TShirts() {}

    @Override
    public void show() {
        System.out.println("大T恤");
        super.show();
    }
}
