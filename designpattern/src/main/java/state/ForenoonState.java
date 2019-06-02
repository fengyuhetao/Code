package state;

/**
 * @author HT
 * @version V1.0
 * @package state
 * @date 2019-05-10 09:06
 */
public class ForenoonState extends State {
    @Override
    public void WriteProgram(Work work) {
        if(work.getHour() < 12) {
            System.out.println("当前时间: " + work.getHour() + "点，上午工作，精神百倍");
        } else {
            work.setState(new NoonState());
            work.WriteProgram();
        }
    }
}
