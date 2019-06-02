package interpreter;

/**
 * @author HT
 * @version V1.0
 * @package interpreter
 * @date 2019-05-12 16:00
 */
public class Main {
    public static void main(String[] args) {
        PlayContext context = new PlayContext();
        System.out.println("上海滩");
        context.setText("O 2 E 0.5 ");
        Expression expression = null;
        try {
            while(context.getText().length() > 0) {
                Character character = context.getText().charAt(0);
                switch (character) {
                    case 'O':
                        expression = new Scale();
                        break;
                    case 'C':
                    case 'D':
                    case 'E':
                    case 'F':
                    case 'G':
                    case 'A':
                    case 'B':
                    case 'P':
                        expression = new Note();
                        break;
                    default:
                        break;
                }
                expression.interpret(context);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
