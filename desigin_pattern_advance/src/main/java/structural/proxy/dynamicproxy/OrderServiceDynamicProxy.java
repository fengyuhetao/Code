package structural.proxy.dynamicproxy;

import structural.proxy.db.DataSourceContextHolder;
import structural.proxy.staticproxy.Order;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author HT
 * @version V1.0
 * @package structural.proxy.dynamicproxy
 * @date 2019-07-03 00:03
 */
public class OrderServiceDynamicProxy implements InvocationHandler {

    private Object taraget;

    public OrderServiceDynamicProxy(Object taraget) {
        this.taraget = taraget;
    }

    public Object bind() throws IllegalAccessException, InstantiationException {
        Class clazz = taraget.getClass();
        return Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object argObject = args[0];
        beforeMethod(argObject);
        Object object = method.invoke(taraget, args);
        afterMethod();
        return object;
    }

    private void afterMethod() {
    }

    private void beforeMethod(Object obj) {
        int userId = 0;
        System.out.println("动态代理 before code");
        if(obj instanceof Order) {
            userId = ((Order) obj).getUserId();
        }
        int dbRouter = userId % 2;
        System.out.println("动态代理分配到dbRouter" + dbRouter + " 处理数据");
        DataSourceContextHolder.setDBType(String.valueOf(dbRouter));
    }
}
