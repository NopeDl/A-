package src.guangjin.java.hotelsystem.app;

import java.util.ArrayList;
import java.util.Scanner;

public class Hotel
{



    public void customerState(User usInfo, ArrayList<User> customerStateList)//顾客状态
    {
        System.out.println("欢迎" + customerStateList.get(usInfo.getCount()).getJudgeVip() + ":" + customerStateList.get(usInfo.getCount()).getUserName()
                    + "\t" + "当前余额:" +customerStateList.get(usInfo.getCount()).getSum() + "\t" + "享受折扣:" + customerStateList.get(usInfo.getCount()).getDiscount());
        customerStateList.add(usInfo);
    }
    public void printRoomInfoForBoss(Room singleRoom, Room twinRoom, Room presentRoom) //打印所有房间信息
    {
        singleRoom.printRoomInfoForBoss(singleRoom);
        twinRoom.printRoomInfoForBoss(twinRoom);
        presentRoom.printRoomInfoForBoss(presentRoom);
        System.out.println();
        System.out.println();
        System.out.println();
    }

    public void printRoomInfoForCs(Room singleRoom, Room twinRoom, Room presentRoom)//打印所有房型的信息
    {
        singleRoom.printRoomInfoForCs(singleRoom);
        twinRoom.printRoomInfoForCs(twinRoom);
        presentRoom.printRoomInfoForCs(presentRoom);
        System.out.println();
        System.out.println();
        System.out.println();
    }
    public void invest(User usInfo, ArrayList<User> customerStateList)//充值
    {
       while (true)
       {
           System.out.println("外来游客可通过门口挂牌汇率充值相应金额");
           System.out.println("请输入你要充值的金额");
           Scanner sc = new Scanner(System.in);
           int num = sc.nextInt();
           if (num <= 0)
           {
               System.out.println("金额输入不合理,请重新输入");
           }
           else
           {
               customerStateList.get(usInfo.getCount()).setSum(customerStateList.get(usInfo.getCount()).getSum() + num);
               break;
           }
       }
        System.out.println();
        System.out.println();
        System.out.println();
    }
    public void beVip(User usInfo, ArrayList<User> customerStateList)//办卡
    {
       while (true)
       {
           System.out.println("办卡需要288，即能成为会员");
           System.out.println("是否办理？是按1，否按2");
           Scanner sc = new Scanner(System.in);
           int temp = sc.nextInt();
           if (temp == 1)
           {
               if ( customerStateList.get(usInfo.getCount()).getSum() < 288)
               {
                   System.out.println("金额不足请前往充值");
                   break;
               }
               customerStateList.get(usInfo.getCount()).setSum( customerStateList.get(usInfo.getCount()).getSum() - 288);
               customerStateList.get(usInfo.getCount()).setJudgeVip("会员");
               customerStateList.get(usInfo.getCount()).setDiscount("八折");
               System.out.println("恭喜你成为会员");
               break;
           }
           else if (temp == 2)
           {
                break;
           }
           else
           {
               System.out.println("无此选项");
           }
       }
        System.out.println();
        System.out.println();
        System.out.println();
    }
    public void checkIn(User usInfo, ArrayList<User> customerStateList, Room singleRoom, Room twinRoom, Room presentRoom) //入住
    {

        System.out.println("请输入你要入住的房间以及天数");
        Scanner sc = new Scanner(System.in);
        String type = sc.next();
        int day = sc.nextInt();
        if (type.equals("单人间") || type.equals("双人间") || type.equals("总统套房"))
        {
            judgeRoomToMove(type, usInfo, day, customerStateList, singleRoom, twinRoom, presentRoom);
        }
        else
        {
            System.out.println("没有此类房间");
        }
        System.out.println();
        System.out.println();
        System.out.println();
    }
    public void judgeRoomToMove(String type, User usInfo, int day, ArrayList<User> customerStateList, Room singleRoom, Room twinRoom, Room presentRoom)//判断什么房间多少晚
    {

        loop:while (true)
        {
            if (type.equals(singleRoom.getType()))
            {
                if(singleRoom.getNum() != 0)
                {
                    if (customerStateList.get(usInfo.getCount()).getSum() < (singleRoom.getPrice() * day))
                    {
                        System.out.println("余额不足，请充值");
                        break loop;
                    }
                    else
                    {
                        if (customerStateList.get(usInfo.getCount()).getJudgeVip().equals("用户"))
                        {
                            customerStateList.get(usInfo.getCount()).setSum(customerStateList.get(usInfo.getCount()).getSum()  - (singleRoom.getPrice() * day));
                        }
                        else {
                            customerStateList.get(usInfo.getCount()).setSum((int) (customerStateList.get(usInfo.getCount()).getSum() - (singleRoom.getPrice() * day * 0.8)));
                        }
                        singleRoom.setNum(singleRoom.getNum() - 1);
                        singleRoom.setUserName(usInfo.getUserName());
                        System.out.println("入住成功，欢迎光临");
                        break loop;
                    }
                }
                else
                {
                    System.out.println("不好意思此类房间已满，请寻求加房");
                    break loop;
                }
            }
            else if (type.equals(twinRoom.getType()))
            {
                if (twinRoom.getNum() != 0)
                {
                    if (customerStateList.get(usInfo.getCount()).getSum() < (twinRoom.getPrice() * day))
                    {
                        System.out.println("余额不足，请充值");
                        break loop;
                    }
                    else
                    {
                        if (customerStateList.get(usInfo.getCount()).getJudgeVip().equals("用户"))
                        {
                            customerStateList.get(usInfo.getCount()).setSum(customerStateList.get(usInfo.getCount()).getSum()  - (twinRoom.getPrice() * day));
                        }
                        else {
                            customerStateList.get(usInfo.getCount()).setSum((int) (customerStateList.get(usInfo.getCount()).getSum() - (twinRoom.getPrice() * day * 0.8)));
                        }
                        twinRoom.setNum(twinRoom.getNum() - 1);
                        twinRoom.setUserName(usInfo.getUserName());
                        System.out.println("入住成功，欢迎光临");
                        break loop;
                    }
                }
                else
                {
                    System.out.println("不好意思此类房间已满，请寻求加房");
                    break loop;
                }
            }

            else if (type.equals(presentRoom.getType()))
            {
               if (presentRoom.getNum() != 0)
               {
                   if (customerStateList.get(usInfo.getCount()).getSum() < (presentRoom.getPrice() * day))
                   {
                       System.out.println("余额不足，请充值");
                       break loop;
                   }
                   else
                   {
                       if (customerStateList.get(usInfo.getCount()).getJudgeVip().equals("用户"))
                       {
                           customerStateList.get(usInfo.getCount()).setSum(customerStateList.get(usInfo.getCount()).getSum()  - (presentRoom.getPrice() * day));
                       }
                       else {
                           customerStateList.get(usInfo.getCount()).setSum((int) (customerStateList.get(usInfo.getCount()).getSum() - (presentRoom.getPrice() * day * 0.8)));
                       }
                       presentRoom.setNum(presentRoom.getNum() - 1);
                       presentRoom.setUserName(usInfo.getUserName());
                       System.out.println("入住成功，欢迎光临");
                       break loop;
                   }
               }
               else
               {
                   System.out.println("不好意思此类房间已满，请寻求加房");
                   break loop;
               }
            }



        }


    }
    public void checkout(User usInfo, Room singleRoom, Room twinRoom, Room presentRoom)
    {

        if (usInfo.getUserName().equals(singleRoom.getUserName()))
        {
            singleRoom.setNum(singleRoom.getNum() + 1);
            System.out.println("您已成功退房，欢迎下次光临");
        }
        else if (usInfo.getUserName().equals(twinRoom.getUserName()))
        {
            twinRoom.setNum(twinRoom.getNum() + 1);
            System.out.println("您已成功退房，欢迎下次光临");
        }
        else if (usInfo.getUserName().equals(presentRoom.getUserName()))
        {
            presentRoom.setNum(presentRoom.getNum() + 1);
            System.out.println("您已成功退房，欢迎下次光临");
        }
        else
        {
            System.out.println("您还未开房间无法退房");
        }
        System.out.println();
        System.out.println();
        System.out.println();
    }

    public void checkState(User usInfo, Room singleRoom, Room twinRoom, Room presentRoom) {
        if (usInfo.getUserName().equals(singleRoom.getUserName())) {
            System.out.println("您现在所居住的房间类型为：" + singleRoom.getType());
        } else if (usInfo.getUserName().equals(twinRoom.getUserName())) {
            System.out.println("您现在所居住的房间类型为：" + twinRoom.getType());
        } else if (usInfo.getUserName().equals(presentRoom.getUserName())) {
            System.out.println("您现在所居住的房间类型为：" + presentRoom.getType());
        } else {
            System.out.println("您还未开房间,无查询消息");
        }
    }
    public void addRoomNumForBoss(Room singleRoom, Room twinRoom, Room presentRoom)//增加房间数量
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要增加的房间类型以及数量");
        String room = sc.next();
        int num = sc.nextInt();
        if (room.equals(singleRoom.getType()))
        {
            singleRoom.setNum(singleRoom.getNum() + num);
            System.out.println("增加成功");
        }
        else if (room.equals(twinRoom.getType()))
        {
            twinRoom.setNum(twinRoom.getNum() + num);
            System.out.println("增加成功");
        }
        else if (room.equals(presentRoom.getType()))
        {
            presentRoom.setNum(presentRoom.getNum() + num);
            System.out.println("增加成功");
        }
        else
        {
            System.out.println("无此类房间");
        }
    }
    public void deleteRoomNum(Room singleRoom, Room twinRoom, Room presentRoom)//减少房间数量
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要删除的房间类型以及数量");
        String room = sc.next();
        int num = sc.nextInt();
        if (room.equals(singleRoom.getType()))
        {
            if (singleRoom.getNum() < num)
            {
                System.out.println("该房间类型数量不足以删除");
            }
            else
            {
                singleRoom.setNum(singleRoom.getNum() - num);
                System.out.println("删除成功");
            }
        }
        else if (room.equals(twinRoom.getType()))
        {
            if (twinRoom.getNum() < num)
            {
                System.out.println("该房间类型数量不足以删除");
            }
            else
            {
                twinRoom.setNum(twinRoom.getNum() - num);
                System.out.println("删除成功");
            }
        }
        else if (room.equals(presentRoom.getType()))
        {
            if (presentRoom.getNum() < num)
            {
                System.out.println("该房间类型数量不足以删除");
            }
            else
            {
                presentRoom.setNum(presentRoom.getNum() - num);
                System.out.println("删除成功");
            }
        }
        else
        {
            System.out.println("无此类房间可删除");
        }
    }
    public void changeRoomType(Room singleRoom, Room twinRoom, Room presentRoom)//装修房间
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("选择想要装修的房间类型  1、单人间  2、双人间  3、总统套房");
        System.out.println("输入您想要装修房间的序号 以及想要变为的房间类型");
        int temp = sc.nextInt();
        String ChangeType = sc.nextLine();
        if (temp == 1)
        {
            singleRoom.setType(ChangeType);
            System.out.println("装修成功");
        }
        if (temp == 2)
        {
            twinRoom.setType(ChangeType);
            System.out.println("装修成功");
        }
        if (temp == 3)
        {
            presentRoom.setType(ChangeType);
            System.out.println("装修成功");
        }
        else
        {
            System.out.println("无此选项");
        }
    }
    public void addRoomNumForCs(Room singleRoom, Room twinRoom, Room presentRoom)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入是什么房间类型数量不足");
        String room = sc.next();
        if (room.equals(singleRoom.getType()))
        {
            singleRoom.setNum(singleRoom.getNum() + 2);
            System.out.println("增加成功");
        }
        else if (room.equals(twinRoom.getType()))
        {
            twinRoom.setNum(twinRoom.getNum() + 2);
            System.out.println("增加成功");
        }
        else if (room.equals(presentRoom.getType()))
        {
            presentRoom.setNum(presentRoom.getNum() + 2);
            System.out.println("增加成功");
        }
        else
        {
            System.out.println("无此类房间");
        }
    }
}


