package unit;

import javax.sql.DataSource;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.SQLException;

//采用JDK动态代理来为业务逻辑层每一个方法都进行事务绑定，提高程序安全性
//通过JDK动态代理来实现AOP，减少“交叉业务”
public class JDKProxyInvocationHandler implements InvocationHandler {
    private Object targe;//目标类对象
    private ThreadLocal<Connection> threadLocal;

    public JDKProxyInvocationHandler(Object targe) {
        //实例化代理对象时将目标对象引进来
        this.targe = targe;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        try {
            //采取ThreadLocal来将当前线程和唯一的连接对象绑定，确保在业务逻辑层每一个中的连接对象有且只有一个
            threadLocal= threadLocaleLe.get();
            Connection connection = threadLocal.get();
            if (connection== null) {
                //将数据源和当前线程绑定
                DataSource dataSource= getDataSourceUtil.getDataSource();
                connection= dataSource.getConnection();
                threadLocal.set(connection);
            }
            //开启事务
            connection.setAutoCommit(false);
            //代理方法
            Object result = method.invoke(targe, args);
            //提交事务
            connection.commit();
            //关闭事务并移除绑定
            connection.close();
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } finally {
            threadLocal.remove();
        }
    }
}
