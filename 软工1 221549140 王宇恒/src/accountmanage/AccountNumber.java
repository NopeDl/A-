package accountmanage;

import java.util.HashMap;
import java.util.Scanner;

public class AccountNumber {
    static Boolean bool=true;
    //判断与注册账号
    public static void isMember(String str, HashMap<String, User> account,HashMap<String,Double>money) {
        Scanner scan = new Scanner(System.in);
        if(account.containsKey(str)){
            if (account.get(str).getMember().equals("会员")) {
                System.out.println("请输入密码");
                String password = scan.next();
                    if (password.equals(account.get(str).getPassward())) {
                        System.out.println("欢迎" + account.get(str).getMember() + ": " + account.get(str).getStr() + " 当前余额" + money.get(str) + "享受折扣：8折");
                        bool=true;
                    } else {
                        System.out.println("密码错误");
                        System.out.println("请随机操作后重新输入账号");
                        bool=false;
                    }//会员
            } else if (account.get(str).getMember().equals("管理员") || account.get(str).getMember().equals("用户")) {
                System.out.println("请输入密码");
                String password = scan.next();
                    if (password.equals(account.get(str).getPassward())) {
                        System.out.println("欢迎" + account.get(str).getMember() + ": " + account.get(str).getStr());
                        bool=true;
                    } else {
                        System.out.println("密码错误");
                        System.out.println("请输入随机数字操作后重新输入账号");
                        bool=false;
                    }//管理员和用户
            }
        }else {
            System.out.println("没有该用户，是否注册（Y)");
            String answer=scan.next();
            if(answer.equals("Y")) {
                System.out.println("请输入要注册的账号");
                String acnumber = scan.next();
                System.out.println("请输入注册密码");
                String acpassword = scan.next();
                System.out.println("请输入用户名");
                String acname = scan.next();
                if (account.containsKey(acnumber)) {
                    System.out.println("该账号已被注册");
                    bool=false;
                    System.out.println("登录失败");
                    System.out.println("请输入随机数字操作后重新输入账号");
                } else {
                    account.put(acnumber, new User(acname, "用户", acpassword));
                    System.out.println("注册成功");
                    bool=true;
                }
            }
            else{
                bool=false;
                System.out.println("登录失败");
                System.out.println("请输入随机数字操作后重新输入账号");
            }
                return;
        }

    }

    public static Boolean getBool() {
        return bool;
    }
}
