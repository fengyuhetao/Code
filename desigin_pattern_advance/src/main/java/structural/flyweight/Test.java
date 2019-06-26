package structural.flyweight;

/**
 * @author HT
 * @version V1.0
 * @package structural.flyweight
 * @date 2019-06-25 00:34
 */
public class Test {
    private static final String departments[] = {"RD", "QA", "PM"};

    public static void main(String[] args) {
        for (int i = 0; i< 10; i++) {
            String department = departments[(int) (Math.random() * departments.length)];
            Manager manager = (Manager) EmployeeFactory.getManager(department);
            manager.report();
        }
    }
}
