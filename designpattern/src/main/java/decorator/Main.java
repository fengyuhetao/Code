package decorator;

/**
 * Created by hetao on 2019/4/24.
 */
public class Main {
    public static void main(String[] args) {
        Man man = new Man("小菜");

        System.out.println("第一种装扮");

        TShirts tShirts = new TShirts();
        tShirts.decorate(man);
        BigTrouser bigTrouser = new BigTrouser();
        bigTrouser.decorate(tShirts);
        bigTrouser.show();
    }
}
