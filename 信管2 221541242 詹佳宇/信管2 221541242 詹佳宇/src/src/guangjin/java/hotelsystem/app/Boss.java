package src.guangjin.java.hotelsystem.app;

import java.util.ArrayList;
import java.util.Scanner;

public class Boss extends User
{
    public Boss() {
    }


    public Boss(String userName, String password, int userHomeNumber, String judgeVip, String discount, int sum, int count) {
        super(userName, password, userHomeNumber, judgeVip, discount, sum, count);
    }

    public void creatBossAccount(ArrayList<User> customerStateList, Boss boss)//创建老板账号
    {
        boss.setUserName("PG");
        boss.setPassword("000111");
        customerStateList.add(boss);
    }

    @Override
    public void work(User usInfo, ArrayList<User> customerStateList,Room singleRoom, Room twinRoom, Room presentRoom )
    {
        Hotel h = new Hotel();
        while (true)
        {
            System.out.println("######欢迎使用旅馆小助手,老板#####");
            System.out.println("----------1、查询所有房间入住信息----------");
            System.out.println("----------2、新增相应房间数量----------");
            System.out.println("----------3、减少相应房间数量----------");
            System.out.println("----------4、装修房间----------");
            Scanner sc = new Scanner(System.in);
            int choose = sc.nextInt();
            switch (choose)
            {
                case 1: {
                    h.printRoomInfoForBoss(singleRoom, twinRoom, presentRoom);
                    break;
                }
                case 2: {
                    h.addRoomNumForBoss(singleRoom, twinRoom, presentRoom);
                    break;
                }
                case 3: {
                    h.deleteRoomNum(singleRoom, twinRoom, presentRoom);
                    break;
                }
                case 4: {
                    h.changeRoomType(singleRoom, twinRoom, presentRoom);
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
