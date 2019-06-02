package state;

/**
 * @author HT
 * @version V1.0
 * @package state
 * @date 2019-05-10 09:17
 */
public class Main {
    public static void main(String[] args) {
        Work emrgencyProject = new Work();
        emrgencyProject.setHour(20d);
        emrgencyProject.WriteProgram();
        emrgencyProject.setHour(21d);
        emrgencyProject.setFinish(true);
        emrgencyProject.WriteProgram();
    }
}
