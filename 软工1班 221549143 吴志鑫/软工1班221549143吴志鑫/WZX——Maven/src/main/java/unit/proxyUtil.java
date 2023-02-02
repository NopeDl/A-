package unit;

import java.lang.reflect.Proxy;

public class proxyUtil {
    public static  Object newProxyInstance(Object target){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new JDKProxyInvocationHandler(target));
    }
}
