package state;

/**
 * @author HT
 * @version V1.0
 * @package state
 * @date 2019-05-10 09:06
 */
public class EveningState extends State {
    @Override
    public void WriteProgram(Work work) {
        if(work.getFinish()) {
            work.setState(new RestState());
            work.WriteProgram();
        } else {
            if(work.getHour() < 21) {
                System.out.println("当前时间:" + work.getHour() + "点，加班哦，疲累之极");
            } else {
                work.setState(new SleepState());
                work.WriteProgram();
            }
        }
    }
}
