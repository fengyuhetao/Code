package observer_update_update;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author HT
 * @version V1.0
 * @package observer_update_update
 * @date 2019-05-09 15:26
 */
public class Event {
    private Object object;

    private String methodName;

    private Object[] params;

    private Class[] paramTypes;

    public Event(Object object, String methodName, Object ...args) {
        this.object = object;
        this.methodName = methodName;
        this.params = args;
        contractParamTypes(this.params);
    }

    private void contractParamTypes(Object[] params) {
        this.paramTypes = new Class[params.length];

        for(int i = 0; i< params.length; i++) {
            this.paramTypes[i] = params[i].getClass();
        }
    }

    public void invoke() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = object.getClass().getMethod(this.methodName, this.paramTypes);
        if(null == method) {
            return ;
        }

        method.invoke(this.object, this.params);
    }
}
