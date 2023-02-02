package src.guangjin.java.hotelsystem.app;

import java.util.ArrayList;
import java.util.Scanner;

public class App
{
    public static void main(String[] args)
    {
        Room singleRoom = new SingleRoom("单人间", null, 0, 75, 10);
        Room twinRoom = new TwinRoom("双人间", null, 0, 100, 10);
        Room presentRoom = new PresentRoom("总统套房", null, 0, 500, 3);
        ArrayList<User> customerStateList = new ArrayList<>();
        Boss boss = new Boss();
        boss.creatBossAccount(customerStateList, boss);
       loop: while (true)
       {
            User usInfo = new Customer("null", null, 9999,"用户", "无", 0, 1);
            System.out.println("######欢迎使用旅馆小助手#####");
            System.out.println("----------1、注册----------");
            System.out.println("----------2、登录----------");
            System.out.println("----------3、退出----------");
            Scanner sc = new Scanner(System.in);
            int choose = sc.nextInt();
            switch (choose)
            {
                case 1: {
                    register(customerStateList, usInfo);
                    break;
                }
                case 2: {
                    login(customerStateList, usInfo, singleRoom, twinRoom, presentRoom);
                    break;
                }
                case 3: {
                    exit();
                    break;
                }
                default: {
                    System.out.println("无此输入项");
                    break;
                }
            }
        }
    }
    private static void register (ArrayList<User> customerStateList,User usInfo )
    {

        Scanner sc = new Scanner(System.in);
        while (true)//用户名
        {
            System.out.println("请输入你所要注册的用户名");
            String impUserName = sc.next();
            boolean flag1 = judgeOnlyName(impUserName, usInfo, customerStateList);//判断用户名是否唯一
            if (flag1)
            {
                System.out.println("用户名已存在");
            }
            else
            {
                System.out.println("用户名录入成功");
                usInfo.setUserName(impUserName);
                break;
            }
        }
        while (true)//密码
        {
            System.out.println("请输入你要设置的密码 需要输入两次一致才能注册成功");
            String password1 = sc.next();
            String password2 = sc.next();
            if (password1.equals(password2))
            {
                usInfo.setPassword(password1);
                System.out.println("密码设置成功,您已完成注册");
                usInfo.setCount(usInfo.getCount() + 1);
                System.out.println();
                System.out.println();
                System.out.println();
                break;
            }
            else
            {
                System.out.println("两次密码不一致请重新输入");
            }
        }
        customerStateList.add(usInfo);
    }
    private static boolean judgeOnlyName(String impUserName, User usInfo,  ArrayList<User> customerStateList)//测试用户名是否唯一
    {
        for (int i = 0; i < customerStateList.size(); i++)
        {
            if (impUserName.equals(customerStateList.get(i).getUserName()) || impUserName.equals("PG"))
            {
                return true;//已存在此用户名
            }
        }
        return false;
    }

    private static void login (ArrayList<User> customerStateList, User usInfo, Room singleRoom, Room twinRoom, Room presentRoom)
    {
        Scanner sc = new Scanner(System.in);
        Boss boss = new Boss();
        System.out.println("请输入用户名");
        String username = sc.next();
        //判断用户名是否存在
        boolean flag = contains(customerStateList, username);
        if (!flag)
        {
            System.out.println("用户名" + username + "未注册，请先注册再登录");
            System.out.println();
            System.out.println();
            System.out.println();
                return;
        }
        System.out.println("请输入密码");
        String password = sc.next();
        boolean result1 = checkCsInfo(customerStateList, usInfo, username ,password);
        if (result1)
            {
                System.out.println("登录成功，可以开始使用小帮手了");
                System.out.println();
                System.out.println();
                System.out.println();
                if (username.equals("PG"))
                {
                    boss.work(usInfo, customerStateList, singleRoom, twinRoom, presentRoom);
                }
                else
                {
                    usInfo.work(usInfo, customerStateList, singleRoom, twinRoom, presentRoom);
                }
            }
        else
            {
                System.out.println("登录失败，用户名或密码错误,请重试");
                System.out.println();
                System.out.println();
                System.out.println();
            }



    }
    private static boolean contains(ArrayList<User> customerStateList, String username)
    {
        //循环遍历集合得到每一个用户对象
        //拿着用户对象中的用户名进行比较
        for (int i = 0; i < customerStateList.size(); i++)
        {
            User user = customerStateList.get(i);
            String rightUsername = user.getUserName();
            if (rightUsername.equals(username))
            {
                return true;
            }
        }
        //当循环结束了，表示集合里面所有的用户都比较完毕了，还没有一样的，则返回false
        return false;
    }
    private static boolean checkCsInfo(ArrayList<User> customerStateList, User usInfo, String username, String password)
    {
        //遍历集合，判断用户是否存在，如果存在登录成功，如果不存在登录失败

            for (int i = 0; i < customerStateList.size(); i++)
            {
                User us= customerStateList.get(i);
                if (us.getUserName().equals(username) && us.getPassword().equals(password))
                {
                    return true;
                }
            }


            return false;
        }

    private static void exit ()
    {
        System.out.println("谢谢使用，再见");
        System.exit(0);
    }

}
