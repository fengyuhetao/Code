package adapter;

/**
 * @author HT
 * @version V1.0
 * @package adapter
 * @date 2019-05-10 10:00
 */
public class Main {
    public static void main(String[] args) {
        Player a = new Forwards("巴蒂尔");
        a.Attack();
        a.Defense();

        Player b = new Translator("姚明");
        b.Defense();
        b.Attack();
    }
}
