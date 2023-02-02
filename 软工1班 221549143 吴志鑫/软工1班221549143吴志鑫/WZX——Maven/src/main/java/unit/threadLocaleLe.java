package unit;

import java.sql.Connection;

public class threadLocaleLe {
    //此类用于关联JDK动态代理处理器中的ThreadLocal对象和持久层的ThreadLocal对象是同一个
    private static ThreadLocal<Connection> threadLocal=new ThreadLocal<>();
    public static ThreadLocal<Connection> get(){
        return threadLocal;
    }
}
