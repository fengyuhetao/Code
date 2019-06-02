package interpreter;

/**
 * @author HT
 * @version V1.0
 * @package interpreter
 * @date 2019-05-12 15:50
 */
public abstract class Expression {
    public void interpret(PlayContext playContext) {
        if(playContext.getText().length() == 0) {
            return;
        } else {
            Character playKey = playContext.getText().charAt(0);
            playContext.setText(playContext.getText().substring(2));
            double playValue = Double.parseDouble(playContext.getText().substring(0, playContext.getText().indexOf(' ')));
            playContext.setText(playContext.getText().substring(playContext.getText().indexOf(" ") + 1));
            execute(playKey, playValue);
        }
    }

    abstract void execute(Character key, double playValue);
}
