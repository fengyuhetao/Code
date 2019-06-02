package observer_update_update;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

abstract class Subject {
    private EventHandler eventHandler = new EventHandler();

    public EventHandler getEventHandler() {
        return eventHandler;
    }

    public void setEventHandler(EventHandler eventHandler) {
        this.eventHandler = eventHandler;
    }

    public abstract void addListener(Object object, String methodName, Object ...args);

    public abstract void notifyObserver() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException;
}
