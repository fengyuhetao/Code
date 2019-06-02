package simplefactory;

import java.util.Scanner;

/**
 * @author HT
 * @version V1.0
 * @package simplefactory
 * @date 2019-04-22 22:58
 */
public class Test {
    public static void main(String[] args) {
        System.out.println("请输入两个整数");
        Scanner in = new Scanner(System.in);
        int numberA = in.nextInt();
        int numberB = in.nextInt();
        Operation operation = OperationFactory.createOperate('+');
        operation.numberA = numberA;
        operation.numberB = numberB;
        System.out.println(operation.getResult());
    }
}
