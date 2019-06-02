package proxy;

/**
 * Created by hetao on 2019/4/25.
 */
public class Main {

    public static void main(String[] args) {
        SchoolGirl schoolGirl = new SchoolGirl();
        schoolGirl.setName("小花");

        Proxy proxy = new Proxy(schoolGirl);

        proxy.GiveDolls();
        proxy.GiveFlowers();
        proxy.GiveChocolate();
    }

}
