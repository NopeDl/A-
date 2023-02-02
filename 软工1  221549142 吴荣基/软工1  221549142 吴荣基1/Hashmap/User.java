package Hashmap;

import HotleSystem00.Hotelapp00;
import HotleSystem01.HotelSystemapp.HotelApp;
import HotleSystem01.Utility;

import java.util.HashMap;

/**
 *Hashmap集中了链表与数组的优点
 * 我设计了两个用户，一个为管理员用户，一个为普通用户，用Hashmap来记录这两’key‘，
 * 他们对应的分别是System01,System00的字符串，首先利用map.get()来寻找’key‘对应的hashmap的值，
 * 并输出，再利用条件判断使用那个系统。
 *
 */

public class User {
    public static void main(String[] args) {
        String name, key;
        HashMap<String, String> map = new HashMap<String, String>();
        //添加管理员用户,普通用户,并且操作系统不同
        //在管理员层设置密码
        map.put("help1", "System01");
        map.put("custom", "System00");
        for (; ; ) {
            System.out.println("=======请输入你的操作用户=======");
            System.out.println("\t\t\t1、管理员");
            System.out.println("\t\t\t2、用户");
            System.out.println("=========请选择（1-2）=========");
            if (Utility.readChar() == '1') {
                System.out.println("请输入你名字");
                if (map.get(Utility.readString(8)).equals("System01")) {
                    System.out.println("你正在使用管理员系统，请输入密码");
                    key = Utility.readString(15);
                    if (key.equals("12345678")) {
                        //默认管理元的密码为12345678
                        Hotelapp00.hotelApp();
                    } else {
                        System.out.println("密码输出错误");
                    }
                }else {
                    System.out.println("不存在该管理员");
                }
            }
            else {
                System.out.println("你正在使用普通用户系统");
                HotelApp.hotelApp();
            }
        }//无限循环
    }
}