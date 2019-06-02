package observer_update_update;

import java.lang.reflect.InvocationTargetException;

/**
 * 秘书类
 *
 * @author HT
 * @version V1.0
 * @package observer
 * @date 2019-05-09 10:47
 */
public class Boss extends Subject {
    @Override
    public void addListener(Object object, String methodName, Object... args) {
        this.getEventHandler().addEvent(object, methodName, args);
    }

    @Override
    public void notifyObserver() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        this.getEventHandler().notifyObserver();
    }
}