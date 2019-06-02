package interpreter;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

/**
 * @author HT
 * @version V1.0
 * @package interpreter
 * @date 2019-05-12 15:55
 */
public class Note extends Expression {
    @Override
    void execute(Character key, double playValue) {
        String note = "";

        switch (key) {
            case 'C':
                note = "1";
                break;
            case 'D':
                note = "2";
                break;
            case 'E':
                note = "3";
                break;
            case 'F':
                note = "4";
                break;
            case 'G':
                note = "5";
                break;
            case 'A':
                note = "6";
                break;
            case 'B':
                note = "7";
                break;
            default:
                break;
        }
        System.out.println(note);
    }
}
