package builder;

/**
 * @author HT
 * @version V1.0
 * @package builder
 * @date 2019-05-09 09:25
 */
public class Main {
    public static void main(String[] args) {
        PersonDirector personDirector = new PersonDirector(new PersonFatBuilder());
        personDirector.createPerson();
    }
}
