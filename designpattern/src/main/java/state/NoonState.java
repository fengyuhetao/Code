package state;

/**
 * @author HT
 * @version V1.0
 * @package state
 * @date 2019-05-10 09:06
 */
public class NoonState extends State {
    @Override
    public void WriteProgram(Work work) {
        if(work.getHour() < 13) {
            System.out.println("当前时间: " + work.getHour() + "点，午饭，犯困，午休");
        } else {
            work.setState(new AfternoonState());
            work.WriteProgram();
        }
    }
}
