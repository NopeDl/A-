package unit;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;

public class wzxSQL {
    private static PreparedStatement pre=null;
    public static Object useWzxSQL(String sql,Class PojoClass,Object...needDatas){
        try {
            ThreadLocal<Connection> threadLocal= threadLocaleLe.get();
            Connection connection = threadLocal.get();
            pre=connection.prepareStatement(sql);
            int i=1;
            for (Object data : needDatas) {
                pre.setObject(i++,data);
            }
            //判断执行的方法是executeQuery还是executeUpdate
            String sqlType= sql.substring(0, 6);
            if("select".equals(sqlType)){
                //DQL
                ResultSet resultSet = pre.executeQuery();
                //获取列数
                ResultSetMetaData metaData = resultSet.getMetaData();
                int columnCount = metaData.getColumnCount();
                i=1;
                //准备一个List集合，如果最终其长度大于一就输出该数组，反之直接输出该单个封装类
                ArrayList<Object> list = new ArrayList<>();
                //封装数据
                while(resultSet.next()){//一次循环遍历出一个封装类对象
                    //获取封装类对象
                    Constructor constructor = PojoClass.getConstructor();
                    Object object = constructor.newInstance();
                    while(i<=columnCount){//一次循环完善一个封装类中的一个属性
                        String columnName = metaData.getColumnName(i);
                        String methodName=null;
                        if(columnName.lastIndexOf("_")==-1){
                            //单位词项名
                            methodName="set"+columnName.substring(0,1).toUpperCase()+
                                    columnName.substring(1);
                        }else{
                            //双位词项名
                            methodName = "set"+columnName.substring(0,1).toUpperCase()+
                                    columnName.substring(1, columnName.lastIndexOf("_")) +
                                    columnName.substring(columnName.lastIndexOf("_") + 1).toUpperCase().substring(0,1)+
                                    columnName.substring(columnName.lastIndexOf("_") + 1).substring(1);
                        }
                        //根据方法名来获取方法对象
                        Method method = PojoClass.getMethod(methodName,resultSet.getObject(i).getClass());
                        //实现方法，为属性赋值
                        method.invoke(object,resultSet.getObject(i));
                                i++;
                    }
                    //将该赋好值的封装类对象纳入list
                    list.add(object);
                    i=1;
                }
                //到了这里，所有的数据都封装为对应的封装类放入到list中，是返回list还是具体封装类对象就看数量了
                if(list.size()>1){
                    //找到多条数据
                    return list;
                }else if (list.size()==1){
                    //找到找到一条数据
                    return list.get(0);
                }else{
                    //找不到数据
                    return null;
                }
            }else{
                //DML
                int affectSum = pre.executeUpdate();
                return affectSum;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
