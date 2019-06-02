package state;

/**
 * @author HT
 * @version V1.0
 * @package state
 * @date 2019-05-10 09:06
 */
public class Work {
    private State state;

    private Double hour;

    private boolean finish = false;

    public Work() {
        state = new ForenoonState();
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public double getHour() {
        return hour;
    }

    public void setHour(double hour) {
        this.hour = hour;
    }

    public boolean getFinish() {
        return finish;
    }

    public void setFinish(boolean finish) {
        this.finish = finish;
    }

    public void WriteProgram() {
        state.WriteProgram(this);
    }
}
