package interpreter;

/**
 * @author HT
 * @version V1.0
 * @package interpreter
 * @date 2019-05-12 15:58
 */
public class Scale extends Expression {
    @Override
    void execute(Character key, double playValue) {
        String scale = "";

        switch ((int) Math.ceil(playValue)){
            case 1:
                scale = "低音";
                break;
            case 2:
                scale = "中音";
                break;
            case 3:
                scale = "高音";
                break;
            default:
                break;
        }

        System.out.println(scale);
    }
}
