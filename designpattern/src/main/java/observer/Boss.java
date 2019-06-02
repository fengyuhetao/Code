package observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 秘书类
 *
 * @author HT
 * @version V1.0
 * @package observer
 * @date 2019-05-09 10:47
 */
public class Boss implements Subject{
    private List<Observer> observerList = new ArrayList<Observer>();

    private String action;

    @Override
    public String getAction() {
        return action;
    }

    @Override
    public void setAction(String action) {
        this.action = action;
    }

    @Override
    public void attach(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObserver() {
        for (Observer observer : observerList) {
            observer.update();
        }
    }
}