package hotel;

import customers.customer;

import java.util.Scanner;

/**
 * @Auther: zhaoss
 * @Date: 2023/1/9 - 01 - 09 - 22:49
 * @Description: hotel
 * @version: 1.0
 */
public class text {
    public static void main(String[] args) throws Exception {
        hotel hotel = new hotel();
        customer customer = new customer();
        room room = new room();
        while (true) {
            System.out.println("--------------欢迎来到旅馆管理系统-------------");
            System.out.print("1.订房用户");
            System.out.print("2.展示房间信息");
            System.out.print("3.添加房间");
            System.out.print("4.用户充值");
            System.out.print("5.办卡");
            System.out.print("6.退房");
            System.out.print("7.退出");
            System.out.println("8:用户信息");
            System.out.println("请选择你想要办理的业务");
            Scanner sc=new Scanner(System.in);
            int choose = sc.nextInt();
            switch (choose) {
                case 1:{
                    System.out.println("请输入你想预定得房间号"); int id = sc.nextInt();
                        hotel.order(id);break;}
                case 2: hotel.print();break;
                case 3:hotel.setRoom(hotel.map);break;
                case 4:customer.exchangeMoney();break;
                case 5:customer.vip();break;
                case 6:{
                    System.out.println("请输入你想退订的房间：");int id1 = sc.nextInt();
                        hotel.exit(id1);break;}
                case 7:{
                    System.out.println("欢迎你下次再来！");return;}
                case 8:{
                    System.out.println("请输入你想查询哪个用户的信息，0~29用户");
                    int id3 = sc.nextInt();
                    hotel.userInfo( id3);break;
                }
                default:{
                        System.out.println("没有你所想选得选项,请重新选择");break;}
            }
        }
    }
}
