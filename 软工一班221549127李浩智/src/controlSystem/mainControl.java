package controlSystem;

import controlSystem.databaseConnect;

import java.util.Scanner;

public class mainControl {

    public void maincontrol() throws Exception//主控制函数
    {
        databaseConnect b = new databaseConnect();
        int x1,x;
        int flag;
        Scanner scan=new Scanner(System.in);
        while(true)
        {
            flag = 1;
            b.mainmenu();//首页菜单
            System.out.println("\t\t请输入选项:");
            x1 = scan.nextInt();
            switch (x1) {
                case 1://顾客登记
                    b.sign();
                 case 2://团体登记
                    b.group_sign();
                 case 3://客房管理
                {
                    System.out.println("请输入您的ID：");
                    String id = scan.next();
                    System.out.println("请输入您的密码：");
                    String psw = scan.next();
                    if (b.login(id, psw) == 1) {
                        while (flag == 1) {
                            b.menu3();//客房管理菜单
                            System.out.println("\t\t请输入选项:");
                            x = scan.nextInt();
                            switch (x) {
                                case 1:
                                    b.increase_room();
                                    break;//增加客房
                                case 2:
                                    b.decrease_room();
                                    break;//减少客房
                                case 3:
                                    flag = 0;
                                    break;//返回
                                case 4:
                                    b.change_roomprice();
                                    break;//修改房价
                                case 5:
                                    b.change_roomtype();
                                    break;//修改房型
                            }
                        }
                    }

                } case 4://设置
                {
                    System.out.println("请输入您的ID：");
                    String id = scan.next();
                    System.out.println("请输入您的密码：");
                    String psw = scan.next();
                    if (b.login(id, psw) == 1) {
                        while (flag == 1) {
                            b.menu4();//设置菜单
                            System.out.println("\t\t请输入选项:");
                            x = scan.nextInt();
                            switch (x) {
                                case 1:
                                    b.change_psw();
                                    break;//修改密码
                                case 2:
                                    b.add_user();
                                    break;//添加用户
                                case 3:
                                    b.delete_user();
                                    break;//删除用户
                                case 4:
                                    flag = 0;
                                    break;//返回
                            }
                        }
                    }

                } case 5://查询
                {
                    while (flag == 1) {
                        b.menu5();//查询菜单
                        System.out.println("\t\t请输入选项:");
                        x = scan.nextInt();
                        switch (x) {
                            case 1:
                                b.show_customer();
                                break;//所有顾客
                            case 2:
                                b.show_group();
                                break;//所有团体
                            case 3:
                                b.show_order();
                                break;//所有订单
                            case 4:
                                flag = 0;
                                break;//返回
                            case 5:
                                b.search_customer2();
                                break;//根据姓氏查询顾客
                            case 6:
                                b.search_customer1();
                                break;//根据身份证号查询顾客
                            case 7:
                                b.search_group();
                                break;//根据团体号查询团体
                            case 8:
                                b.search_roomtype();
                                break;//根据顾客电话查询房间类型
                            case 9:
                                b.available_rooms();
                                break;//预定客房或登记入住
                        }
                    }
                } case 6://退房
                {
                    while (flag == 1) {
                        b.menu6();//退房菜单
                        System.out.println("\t\t请输入选项:");
                        x = scan.nextInt();
                        switch (x) {
                            case 1:
                                b.customer_exit();
                                break;//顾客退房
                            case 2:
                                b.group_exit();
                                break;//团体退房
                            case 3:
                                flag = 0;
                                break;//返回

                        }
                    }
                }
            }
        }

    }
}


