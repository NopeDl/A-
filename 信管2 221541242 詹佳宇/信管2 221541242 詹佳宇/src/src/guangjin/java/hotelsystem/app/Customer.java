package src.guangjin.java.hotelsystem.app;

import java.util.ArrayList;
import java.util.Scanner;

public class Customer extends User {


    public Customer() {
    }

    public Customer(String userName, String password, int userHomeNumber, String judgeVip, String discount, int sum, int count) {
        super(userName, password, userHomeNumber, judgeVip, discount, sum, count);
    }

    @Override
    public void work(User usInfo, ArrayList<User> customerStateList, Room singleRoom, Room twinRoom, Room presentRoom) {

        Hotel h = new Hotel();

        loop:while (true) {
            System.out.println("######欢迎使用旅馆小助手,亲爱的顾客#####");
            h.customerState(usInfo, customerStateList);
            System.out.println("----------1、所有房型的信息----------");
            System.out.println("----------2、开房----------");
            System.out.println("----------3、退房----------");
            System.out.println("----------4、查看自己的房卡----------");
            System.out.println("----------5、充值----------");
            System.out.println("----------6、办卡----------");
            System.out.println("----------7、切换用户----------");
            System.out.println("----------8、需求建议----------");
            Scanner sc = new Scanner(System.in);
            int choose = sc.nextInt();
            switch (choose) {
                case 1: {
                    h.printRoomInfoForCs(singleRoom, twinRoom, presentRoom);
                    break;
                }
                case 2: {
                    h.checkIn(usInfo, customerStateList, singleRoom, twinRoom, presentRoom);
                    break;
                }
                case 3: {
                    h.checkout(usInfo, singleRoom, twinRoom, presentRoom);
                    break;
                }
                case 4: {
                    h.checkState(usInfo, singleRoom, twinRoom, presentRoom);
                    break;
                }
                case 5: {
                    h.invest(usInfo, customerStateList);
                    break;
                }
                case 6: {
                    h.beVip(usInfo, customerStateList);
                    break;
                }
                case 7:
                {
                    break loop;
                }
                case 8: {
                    h.addRoomNumForCs(singleRoom, twinRoom, presentRoom);
                    break;
                }
                default: {
                    System.out.println("无此输入项");
                    break;
                }
            }

        }
    }
}