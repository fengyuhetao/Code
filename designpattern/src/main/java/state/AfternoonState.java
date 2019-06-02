package state;

/**
 * @author HT
 * @version V1.0
 * @package state
 * @date 2019-05-10 09:06
 */
public class AfternoonState extends State {
    @Override
    public void WriteProgram(Work work) {
        if(work.getHour() < 17) {
            System.out.println("当前时间: " + work.getHour() + "点，下午状态还不错，继续努力");
        } else {
            work.setState(new EveningState());
            work.WriteProgram();
        }
    }
}
