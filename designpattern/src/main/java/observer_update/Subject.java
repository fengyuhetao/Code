package observer_update;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

abstract class Subject {
    protected Method update;

    protected String action;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public void notifyObserver(Object object) {
        if(update != null) {
            try {
                update.invoke(object, action);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } finally {

            }
        }
    }
}
