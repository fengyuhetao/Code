package decorator;

/**
 * Created by hetao on 2019/4/24.
 */
public class Man implements Person {
    private String name;

    public Man(String name) {
        this.name = name;
    }

    public void show() {
        System.out.println("装扮的男人是:" + name);
    }
}
