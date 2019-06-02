package state;

/**
 * @author HT
 * @version V1.0
 * @package state
 * @date 2019-05-10 09:06
 */
public class RestState extends State {
    @Override
    public void WriteProgram(Work work) {
        System.out.println("当前时间: " + work.getHour() + "点，下班回家了");
    }
}
