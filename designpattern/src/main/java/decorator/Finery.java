package decorator;

/**
 * 装饰类
 * Created by hetao on 2019/4/24.
 */
public class Finery implements Person{
    protected Person person;

    public void decorate(Person person) {
        this.person = person;
    }

    public void show() {
        if(person != null) {
            person.show();
        }
    }
}
