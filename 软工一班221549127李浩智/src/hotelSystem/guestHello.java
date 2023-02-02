package hotelSystem;

import java.util.Scanner;

public class guestHello {
        private static String password="lhz_221549127";
        public static void main(String[] args) {
            Hotel h = new Hotel();
            Scanner sc = new Scanner(System.in);
            System.out.println("尊敬的顾客您好！欢迎光临java酒店");
            System.out.println("请选择您需要的服务");
            System.out.println("1:查看房间列表，2:订房，3:退房，4:退出系统，5:办理会员，6:更换住房，7:充值，8:进入管理员专用系统");
            //用一个while循环，可以使得系统的操作多次使用
            while (true) {
                System.out.println("请输入数字选择需要的操作");
                int i = sc.nextInt();
                if (i == 1) {
                    //查看房间列表
                    h.check();
                }
                if (i == 2) {
                    //订房，先充值再开房
                    System.out.println("请输入要订房的房间编号以及您的身份证号和姓名：");
                    int a = sc.nextInt();
                    String idCard=sc.next();
                    String idName=sc.next();
                    h.order(a,idCard,idName);
                    System.out.println("订房成功");
                }
                if (i == 3) {
                    //退房
                    System.out.println("请输入要退房的房间编号");
                    int b = sc.nextInt();
                    h.exit(b);
                    System.out.println("退房成功");
                }
                if (i == 4) {
                    //退出系统
                    int x=h.guestMoney();
                    if(x<0){
                        System.out.println("抱歉，您还有未付房费");
                        System.out.println(h.guestMoney());
                    }
                    else {
                        System.out.println("退出成功，感谢您的入住，欢迎下次光临！");
                        return;
                    }
                }
                if(i==5){
                    h.vipPay();
                    System.out.println("感谢您升级成为酒店会员");
                }
                if(i==6){
                    Hotel change=new Hotel();
                    System.out.println("请输入您原来的房间号");
                    int c=sc.nextInt();
                    change.roomsChange(c);
                    System.out.println("房间更换成功");
                }
                if(i==7){    //充值
                    System.out.println("请输入您要充值的钱");
                    int c=sc.nextInt();
                    h.charge(c);
                }
                if(i==8) {
                    System.out.println("请输入管理员密码:");
                    String d = sc.next();
                    if (d.equals(password)) {
                        System.out.print("------欢迎使用管理员系统-------\n");
                        System.out.print("请选择功能：\n");
                        System.out.print("1.查询客户所有信息，2.更改房间类型，3.更改房间价格，4.回到主系统，5.离开操作系统\n");
                        controlSystem c=new controlSystem();
                        int x=sc.nextInt();
                        int flag=1;
                        while(flag==1) {
                            if (x == 1) {
                                c.check();
                                break;
                            }
                            if (x == 2 || x == 3) {
                                System.out.println("请输入要修改的房间号");
                                int id = sc.nextInt();
                                c.roomsChange(id);
                                break;
                            }
                            if (x == 4) //回到主系统
                                flag = 0;
                            if (x == 5) {    //离开操作系统
                                System.out.println();
                                return;
                            }
                        }
                    }
                }

            }
        }
}
