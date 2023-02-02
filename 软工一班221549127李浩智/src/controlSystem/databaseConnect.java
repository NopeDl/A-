package controlSystem;

import java.sql.*;
import java.util.Scanner;
import java.util.Vector;
public class databaseConnect {
    private String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private String dbURL="jdbc:sqlserver://localhost:1433;DatabaseName=宾馆客房管理系统";
    private  String userName="sa";
    private String userPwd="lhz221549127";
    private  Connection ct=null;
    private ResultSet rs=null;
    private Statement st;
    static int number = 0;

    public void mainmenu()//主菜单
    {
        System.out.println("\n\n");
        System.out.println("\t\t* * * * * * 酒店管理系统 * * * * * *\n");
        System.out.println("\t\t*           1.:顾客登记                  *\n");
        System.out.println("\t\t*           2.:团体登记                  *\n");
        System.out.println("\t\t*           3.:客房管理                  *\n");
        System.out.println("\t\t*           4.:设置                      *\n");
        System.out.println("\t\t*           5.:查询                      *\n");
        System.out.println("\t\t*           6.:退房                      *\n");
        System.out.println("\t\t* * * * * * * * * * * * * * * * *  * * *\n\n");
    }
    public void menu5()//查询
    {
        System.out.println("\n\n");
        System.out.println("\t\t* * * * * * 酒店管理系统 * * * * * *\n");
        System.out.println("\t\t*           1.:所有顾客                  *\n");
        System.out.println("\t\t*           2.:所有团体                  *\n");
        System.out.println("\t\t*           3.:所有订单                  *\n");
        System.out.println("\t\t*           4.:返回                      *\n");
        System.out.println("\t\t*           5.:根据姓氏查询顾客          *\n");
        System.out.println("\t\t*           6.:根据身份证号查询顾客      *\n");
        System.out.println("\t\t*           7.:根据团体号查询团体信息    *\n");
        System.out.println("\t\t*     8.:根据顾客电话查询顾客的房间类型  *\n");
        System.out.println("\t\t*           9.:可用房间                  *\n");
        System.out.println("\t\t* * * * * * * * * * * * * * * * *  * * *\n\n");
    }
    public void menu6()//退房
    {
        System.out.println("\n\n");
        System.out.println("\t\t* * * * * * 酒店管理系统 * * * * * *\n");
        System.out.println("\t\t*           1.:顾客退房                  *\n");
        System.out.println("\t\t*           2.:团体退房                  *\n");
        System.out.println("\t\t*           3.:返回                      *\n");
        System.out.println("\t\t* * * * * * * * * * * * * * * * *  * * *\n\n");
    }
    public void menu3()//客房管理
    {
        System.out.println("\n\n");
        System.out.println("\t\t* * * * * * 酒店管理系统 * * * * * *\n");
        System.out.println("\t\t*           1.:增加客房                  *\n");
        System.out.println("\t\t*           2.:减少客房                  *\n");
        System.out.println("\t\t*           3.:返回                      *\n");
        System.out.println("\t\t*           4.:更改房价                  *\n");
        System.out.println("\t\t*           5.:更改房间类型              *\n");
        System.out.println("\t\t* * * * * * * * * * * * * * * * *  * * *\n\n");
    }

    public void menu4()//设置
    {
        System.out.println("\n\n");
        System.out.println("\t\t* * * * * * 酒店管理系统 * * * * * *\n");
        System.out.println("\t\t*           1.:修改密码                  *\n");
        System.out.println("\t\t*           2.:添加用户                  *\n");
        System.out.println("\t\t*           3.:删除用户                  *\n");
        System.out.println("\t\t*           4.:返回                      *\n");
        System.out.println("\t\t* * * * * * * * * * * * * * * * *  * * *\n\n");
    }
    public void search_roomtype() throws Exception//根据顾客电话查询房间类型
    {
        Scanner scan=new Scanner(System.in);
        System.out.println("请输入顾客的手机号");
        String num = scan.next();
        Class.forName(driverName);
        ct=DriverManager.getConnection(dbURL,userName,userPwd);
        st=ct.createStatement();
        String sql = "select 房间类型 from 顾客登记,订单 where 顾客登记.订单号=订单.订单号 and 顾客电话 = '"+num+"'";
        rs = st.executeQuery(sql);
        while (rs.next())
        {
            System.out.println("房间类型:"+rs.getString("房间类型") );
        }
        if(rs!=null)
            rs.close();
        if(st!=null)
            st.close();
        if(ct!=null)
            ct.close();
    }
    public void search_group() throws Exception//根据团体号查询团体信息
    {
        Scanner scan=new Scanner(System.in);
        System.out.println("请输入您想查询团体的团体号：");
        String num = scan.next();
        Class.forName(driverName);
        ct=DriverManager.getConnection(dbURL,userName,userPwd);
        st=ct.createStatement();
        String sql = "select * from 团体登记 where 团体号 = '"+num+"'";
        rs = st.executeQuery(sql);
        while (rs.next())
        {
            System.out.println("团体名:"+rs.getString("团体名") + "\n团体号:" + rs.getString("团体号")
                    + "\n团体电话:" + rs.getString("团体电话")+ "\n团体人数:" + rs.getString("团体人数")+ "\n订单号:" + rs.getString("订单号"));
        }
        if(rs!=null)
            rs.close();
        if(st!=null)
            st.close();
        if(ct!=null)
            ct.close();
    }

    public void search_customer2() throws Exception//根据姓氏查询顾客
    {
        Scanner scan=new Scanner(System.in);
        System.out.println("请输入您想查询顾客的姓");
        String name1 = scan.next();
        Class.forName(driverName);
        ct=DriverManager.getConnection(dbURL,userName,userPwd);
        st=ct.createStatement();
        String sql = "select * from 顾客登记 where 顾客姓名 like '"+name1+"%'";
        rs = st.executeQuery(sql);
        while (rs.next())
        {
            System.out.println("顾客姓名:"+rs.getString("顾客姓名") + "\n顾客身份证号:" + rs.getString("顾客身份证号")
                    + "\n顾客电话:" + rs.getString("顾客电话")+ "\n顾客性别:" + rs.getString("顾客性别")+ "\n订单号:" + rs.getString("订单号"));
        }
        if(rs!=null)
            rs.close();
        if(st!=null)
            st.close();
        if(ct!=null)
            ct.close();
    }
    public void search_customer1() throws Exception//根据身份证号查询顾客
    {
        Scanner scan=new Scanner(System.in);
        System.out.println("请输入您想查询顾客的身份证号");
        String ID = scan.next();
        Class.forName(driverName);
        ct=DriverManager.getConnection(dbURL,userName,userPwd);
        st=ct.createStatement();
        String sql = "select * from 顾客登记 where 顾客身份证号 = '"+ID+"'";
        rs = st.executeQuery(sql);
        while (rs.next())
        {
            System.out.println("顾客姓名:"+rs.getString("顾客姓名") + "\n顾客身份证号:" + rs.getString("顾客身份证号")
                    + "\n顾客电话:" + rs.getString("顾客电话")+ "\n顾客性别:" + rs.getString("顾客性别")+ "\n订单号:" + rs.getString("订单号"));
        }
        if(rs!=null)
            rs.close();
        if(st!=null)
            st.close();
        if(ct!=null)
            ct.close();
    }
    public void change_roomprice() throws Exception//更改房价
    {
        Scanner scan=new Scanner(System.in);
        System.out.println("请输入您想更改的房型");
        String roomtype = scan.next();
        System.out.println("请输入修改后的房价");
        int price = scan.nextInt();
        Class.forName(driverName);
        ct=DriverManager.getConnection(dbURL,userName,userPwd);
        st=ct.createStatement();
        String sql = "update 房间信息 set 房间价格 = "+price+" where 房间类型 = '"+roomtype+"'";
        st.executeUpdate(sql);
        System.out.println("修改成功");
        if(st!=null)
            st.close();
        if(ct!=null)
            ct.close();
    }
    public void change_roomtype() throws Exception//更改房间类型
    {
        Scanner scan=new Scanner(System.in);
        System.out.println("请输入您想更改的房间号");
        String roomnum = scan.next();
        System.out.println("请输入您想更改的房型");
        String roomtype = scan.next();
        Class.forName(driverName);
        ct=DriverManager.getConnection(dbURL,userName,userPwd);
        st=ct.createStatement();
        String sql = "update 房间信息 set 房间类型 = '"+roomtype+"' where 房间号 = '"+roomnum+"'";
        st.executeUpdate(sql);
        System.out.println("修改成功");
        if(st!=null)
            st.close();
        if(ct!=null)
            ct.close();
    }
    public void show_group() throws Exception//所有团体
    {
        Class.forName(driverName);
        ct=DriverManager.getConnection(dbURL,userName,userPwd);
        st=ct.createStatement();
        rs=st.executeQuery("select * from 团体登记");
        while (rs.next())
        {
            System.out.println("团体名: "+rs.getString("团体名") + " 团体号: " + rs.getString("团体号")
                    + " 团体电话: " + rs.getString("团体电话")+ " 团体人数: " + rs.getInt("团体人数")+ " 订单号: " + rs.getString("订单号"));
        }
        if(rs!=null)
            rs.close();
        if(st!=null)
            st.close();
        if(ct!=null)
            ct.close();
    }
    public void show_customer() throws Exception//所有顾客
    {
        Class.forName(driverName);
        ct=DriverManager.getConnection(dbURL,userName,userPwd);
        st=ct.createStatement();
        rs=st.executeQuery("select * from 顾客登记");
        while (rs.next())
        {
            System.out.println("顾客姓名: "+rs.getString("顾客姓名") + " 顾客身份证号: " + rs.getString("顾客身份证号")
                    + "   顾客电话: " + rs.getString("顾客电话")+ "    顾客性别: " + rs.getString("顾客性别")+ " 订单号： " + rs.getString("订单号"));
        }
        if(rs!=null)
            rs.close();
        if(st!=null)
            st.close();
        if(ct!=null)
            ct.close();
    }
    public void show_order() throws Exception//所有订单
    {
        Class.forName(driverName);
        ct=DriverManager.getConnection(dbURL,userName,userPwd);
        st=ct.createStatement();
        rs=st.executeQuery("select * from 订单");
        while (rs.next())
        {
            System.out.println("订单号: "+rs.getString("订单号") + " 入住天数: " + rs.getInt("入住天数")
                    + " 房间类型: " + rs.getString("房间类型")+ " 订房数量: " + rs.getInt("订房数量")+ " 总金额： " + rs.getInt("总金额")
                    + " 入住时间： " + rs.getString("入住时间")+ " 房间号： " + rs.getString("房间号"));
        }
        if(rs!=null)
            rs.close();
        if(st!=null)
            st.close();
        if(ct!=null)
            ct.close();
    }
    public void group_exit() throws Exception//团体退房
    {
        Scanner scan=new Scanner(System.in);
        System.out.println("请输入团体号");
        String ID = scan.next();
        System.out.println("请输入需要退的房间数量");
        int num = scan.nextInt();
        for(int i=0;i<num;i++)
        {
            System.out.println("请输入房间号");
            String number = scan.next();
            Class.forName(driverName);
            ct=DriverManager.getConnection(dbURL,userName,userPwd);
            st=ct.createStatement();
            String sql = "update 房间信息 set 是否入住 = '否' where 房间号 = '"+number+"'";
            st.executeUpdate(sql);
        }
        String sql2 = "select 总金额 from 订单,团体登记 where 订单.订单号 = 团体登记.订单号 and 团体号 = '"+ID+"'";
        rs=st.executeQuery(sql2);
        while (rs.next())
        {
            System.out.println("顾客需支付金额为： "+rs.getString("总金额"));
        }
        System.out.println("离店操作成功");
        if(st!=null)
            st.close();
        if(ct!=null)
            ct.close();
    }
    public void customer_exit() throws Exception//顾客退房
    {
        Scanner scan=new Scanner(System.in);
        System.out.println("请输入顾客身份证号");
        String ID = scan.next();
        String number=null;
        Class.forName(driverName);
        ct=DriverManager.getConnection(dbURL,userName,userPwd);
        st=ct.createStatement();
        rs=st.executeQuery("select 房间号 from 顾客登记 where 顾客身份证号 = '"+ID+"'");
        while (rs.next())
        {
            number = rs.getString("房间号");
        }
        String sql = "update 房间信息 set 是否入住 = '否' where 房间号 = '"+number+"'";
        String sql2 = "select 总金额 from 订单,顾客登记 where 订单.订单号 = 顾客登记.订单号 and 顾客身份证号 = '"+ID+"'";
        st.executeUpdate(sql);
        rs=st.executeQuery(sql2);
        while (rs.next())
        {
            System.out.println("顾客需支付金额为： "+rs.getString("总金额"));
        }
        System.out.println("离店操作成功");
        if(st!=null)
            st.close();
        if(ct!=null)
            ct.close();
    }
    public void change_psw() throws Exception//修改密码
    {
        Scanner scan=new Scanner(System.in);
        System.out.println("请输入操作员ID");
        String ID = scan.next();
        System.out.println("请输入新的密码");
        String number = scan.next();
        Class.forName(driverName);
        ct=DriverManager.getConnection(dbURL,userName,userPwd);
        st=ct.createStatement();
        String sql = "update 操作员信息 set 密码 = '"+number+"' where 操作员ID = '"+ID+"'";
        st.executeUpdate(sql);
        System.out.println("修改密码成功");
        if(st!=null)
            st.close();
        if(ct!=null)
            ct.close();
    }
    public void add_user() throws Exception//添加用户
    {
        Scanner scan=new Scanner(System.in);
        System.out.println("请输入新的操作员ID");
        String ID = scan.next();
        System.out.println("请输入密码");
        String number = scan.next();
        Class.forName(driverName);
        ct=DriverManager.getConnection(dbURL,userName,userPwd);
        st=ct.createStatement();
        String sql = "insert into 操作员信息 values"+"('"+ID+"','"+number+"')";
        st.executeUpdate(sql);
        System.out.println("添加用户成功");
        if(st!=null)
            st.close();
        if(ct!=null)
            ct.close();
    }
    public void delete_user() throws Exception//删除用户
    {
        Scanner scan=new Scanner(System.in);
        System.out.println("请输入需要删除的操作员ID");
        String ID = scan.next();
        Class.forName(driverName);
        ct=DriverManager.getConnection(dbURL,userName,userPwd);
        st=ct.createStatement();
        String sql = "delete from 操作员信息 where 操作员ID = '"+ID+"'";
        st.executeUpdate(sql);
        System.out.println("删除成功");
        if(st!=null)
            st.close();
        if(ct!=null)
            ct.close();
    }
    public void increase_room() throws Exception//增加客房
    {
        Scanner scan=new Scanner(System.in);
        System.out.println("请输入增加客房数量");
        int roomnum = scan.nextInt();
        for(int i = 0; i<roomnum; i++)
        {
            System.out.println("请输入增加客房的房型");
            String roomtype = scan.next();
            System.out.println("请输入房间价格");
            int price = scan.nextInt();
            System.out.println("请输入新的房间号");
            String number = scan.next();
            Class.forName(driverName);
            ct=DriverManager.getConnection(dbURL,userName,userPwd);
            st=ct.createStatement();
            String sql = "insert into 房间信息 values"+"('"+number+"','"+roomtype+"','否',"+price+")";
            st.executeUpdate(sql);
            System.out.println("添加成功");
        }
        if(st!=null)
            st.close();
        if(ct!=null)
            ct.close();
    }
    public void decrease_room() throws Exception//减少客房
    {
        Scanner scan=new Scanner(System.in);
        System.out.println("请输入需要删除的房间号");
        String number = scan.next();
        Class.forName(driverName);
        ct=DriverManager.getConnection(dbURL,userName,userPwd);
        st=ct.createStatement();
        String sql = "delete from 房间信息 where 房间号 = '"+number+"'";
        st.executeUpdate(sql);
        System.out.println("删除成功");
        if(st!=null)
            st.close();
        if(ct!=null)
            ct.close();
    }
    public void creat_order(String order) throws Exception//生成订单
    {
        Vector<Object> data=new Vector<Object>();
        int total_price=0;
        Scanner scan=new Scanner(System.in);
        System.out.println("请输入入住天数");
        int days = scan.nextInt();
        System.out.println("请输入房间类型");
        String roomtype = scan.next();
        System.out.println("请输入订房数量");
        int roomnum = scan.nextInt();
        String time=null;
        System.out.println("请输入房间号");
        String roomnumber = scan.next();
        Class.forName(driverName);
        ct=DriverManager.getConnection(dbURL,userName,userPwd);
        st=ct.createStatement();
        rs=st.executeQuery("select 房间价格 from 房间信息 where 房间类型 = '"+roomtype+"'");
        while(rs.next())
        {
            total_price = days*roomnum *rs.getInt("房间价格");
        }
        String sql3 = "select CONVERT(varchar, getdate(), 120 ) 当前时间";
        rs=st.executeQuery(sql3);
        while(rs.next())
        {
            time = rs.getString("当前时间");
        }
        String sql = "insert into 订单 values"+"('"+order+"',"+days+",'"+
                roomtype+"',"+roomnum+","+total_price+",'"+time+"','"+roomnumber+"')";
        st.executeUpdate(sql);
        System.out.println("订单生成成功");
    }
    public void group_sign() throws Exception//团体登记
    {
        databaseConnect g = new databaseConnect();
        Scanner scan=new Scanner(System.in);
        System.out.println("请输入团体名");
        String name = scan.next();
        System.out.println("请输入团体号");
        String pID = scan.next();
        System.out.println("请输入团体电话");
        String phonenum = scan.next();
        System.out.println("请输入团体人数");
        int people = scan.nextInt();
        System.out.println("请输入订单号");
        String order = scan.next();
        Class.forName(driverName);
        ct=DriverManager.getConnection(dbURL,userName,userPwd);
        st=ct.createStatement();
        String sql = "insert into 团体登记 values"+"('"+name+"','"+pID+"','"+phonenum+"',"+people+",'"+order+"')";
        st.executeUpdate(sql);
        for(int i = 0; i<people; i++)
        {
            System.out.println("第"+(i+1)+"位客人");
            System.out.println("请输入您的姓名");
            String name1 = scan.next();
            System.out.println("请输入您的身份证号");
            String pID1 = scan.next();
            System.out.println("请输入您的电话");
            String phonenum1 = scan.next();
            System.out.println("请输入您的性别");
            String gender = scan.next();
            System.out.println("请输入订单号");
            String order1 = scan.next();
            System.out.println("请输入房间号");
            String roomnum1 = scan.next();
            Class.forName(driverName);
            ct=DriverManager.getConnection(dbURL,userName,userPwd);
            st=ct.createStatement();
            String sql1 = "insert into 顾客登记 values"+"('"+name1+"','"+pID1+"','"+phonenum1+"','"+gender+"','"+order1+"','"+roomnum1+"')";
            st.executeUpdate(sql1);
            String sql2 = "update 房间信息 set 是否入住 = '是'  where 房间号 = '"+roomnum1+"'";
            st.executeUpdate(sql2);
            System.out.println("登记成功");
        }
        g.creat_order(order);//生成订单
        System.out.println("团体登记成功");
        ct.commit();
        if(st!=null)
            st.close();
        if(ct!=null)
            ct.close();
    }

    public void sign() throws Exception//顾客登记
    {
        databaseConnect f = new databaseConnect();
        Scanner scan=new Scanner(System.in);
        System.out.println("请输入您的姓名");
        String name = scan.next();
        System.out.println("请输入您的身份证号");
        String pID = scan.next();
        System.out.println("请输入您的电话");
        String phonenum = scan.next();
        System.out.println("请输入您的性别");
        String gender = scan.next();
        System.out.println("请输入订单号");
        String order = scan.next();
        System.out.println("请输入房间号");
        String roomnum = scan.next();
        Class.forName(driverName);
        ct=DriverManager.getConnection(dbURL,userName,userPwd);
        st=ct.createStatement();
        String sql = "insert into 顾客登记 values"+"('"+name+"','"+pID+"','"+phonenum+"','"+gender+"','"+order+"','"+roomnum+"')";
        st.executeUpdate(sql);
        String sql1 = "update 房间信息 set 是否入住 = '是'  where 房间号 = '"+roomnum+"'";
        st.executeUpdate(sql1);

        Vector<Object> data=new Vector<Object>();
        int total_price=0;
        System.out.println("请输入入住天数");
        int days = scan.nextInt();
        System.out.println("请输入房间类型");
        String roomtype = scan.next();
        System.out.println("请输入订房数量");
        int roomnum1 = scan.nextInt();
        String time = null;

        Class.forName(driverName);
        ct=DriverManager.getConnection(dbURL,userName,userPwd);
        st=ct.createStatement();
        rs=st.executeQuery("select 房间价格 from 房间信息 where 房间类型 = '"+roomtype+"'");
        while(rs.next())
        {
            total_price = days*roomnum1 *rs.getInt("房间价格");
        }
        String sql3 = "select CONVERT(varchar, getdate(), 120 ) 当前时间";
        rs=st.executeQuery(sql3);
        while(rs.next())
        {
            time = rs.getString("当前时间");
        }
        String sql2 = "insert into 订单 values"+"('"+order+"',"+days+",'"+
                roomtype+"',"+roomnum1+","+total_price+",'"+time+"',"+roomnum+")";
        st.executeUpdate(sql2);
        System.out.println("订单生成成功");


        System.out.println("登记成功");
        ct.commit();
        if(st!=null)
            st.close();
        if(ct!=null)
            ct.close();
    }
    public int login(String id,String psw) throws Exception//登录系统
    {
        Vector<Object> data1=new Vector<Object>();
        Vector<Object> data2=new Vector<Object>();
        Class.forName(driverName);
        ct=DriverManager.getConnection(dbURL,userName,userPwd);
        st=ct.createStatement();
        rs=st.executeQuery("select * from 操作员信息");
        while(rs.next())
        {
            data1.add(rs.getString(1));
            data2.add(rs.getString(2));
        }
        for(int i = 0; i < data1.size(); i++)
        {
            if(id.equals(data1.elementAt(i)) && psw.equals(data2.elementAt(i)))
            {
                System.out.println("登录成功");
                if(rs!=null)
                    rs.close();
                if(st!=null)
                    st.close();
                if(ct!=null)
                    ct.close();
                return 1;
            }
        }
        System.out.println("登录失败");
        if(rs!=null)
            rs.close();
        if(st!=null)
            st.close();
        if(ct!=null)
            ct.close();
        return 0;
    }

    public void available_rooms() throws Exception//可用房间
    {
        Class.forName(driverName);
        ct=DriverManager.getConnection(dbURL,userName,userPwd);
        st=ct.createStatement();
        rs=st.executeQuery("select * from 房间信息 where 是否入住 = '否' ");

        while (rs.next())
        {
            System.out.println("房间号： "+rs.getString("房间号") + " 房间类型： " + rs.getString("房间类型")
                    + "      房间价格： " + rs.getString("房间价格"));
        }
        if(rs!=null)
            rs.close();
        if(st!=null)
            st.close();
        if(ct!=null)
            ct.close();
    }
    public static void main(String[] args) throws Exception
    {
        mainControl a = new mainControl();
        a.maincontrol();//进入主控制函数;
    }
}
