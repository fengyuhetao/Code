package structural.decorator;

import structural.decorator.v1.BatterCake;
import structural.decorator.v1.BatterCakeWithEgg;
import structural.decorator.v2.ABatterCake;
import structural.decorator.v2.EggDecorator;
import structural.decorator.v2.SausageDecorator;

/**
 * @author HT
 * @version V1.0
 * @package structural.decorator
 * @date 2019-06-23 13:11
 */
public class Test {
    public static void main(String[] args) {
        testV2();
    }

    public static void testV1() {
        BatterCake batterCake = new BatterCake();
        System.out.println(batterCake.getDesc() + "价格：" + batterCake.cost());

        BatterCake batterCakeWithEgg = new BatterCakeWithEgg();
        System.out.println(batterCakeWithEgg.getDesc() + "价格：" + batterCakeWithEgg.cost());
    }

    public static void testV2() {
        ABatterCake aBatterCake;
        aBatterCake = new structural.decorator.v2.BatterCake();
        aBatterCake = new EggDecorator(aBatterCake);
        aBatterCake = new EggDecorator(aBatterCake);
        aBatterCake = new SausageDecorator(aBatterCake);
        System.out.println(aBatterCake.getDesc());
        System.out.println(aBatterCake.cost());
    }
}
