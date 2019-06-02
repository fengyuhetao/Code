package observer_update_update;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author HT
 * @version V1.0
 * @package observer_update_update
 * @date 2019-05-09 15:30
 */
public class EventHandler {
    private List<Event> eventList;

    public EventHandler() {
        eventList = new ArrayList<Event>();
    }

    public void addEvent(Object object, String methodName, Object ...args) {
        eventList.add(new Event(object, methodName, args));
    }

    public void notifyObserver() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        for(Event event: eventList) {
            event.invoke();
        }
    }
}
