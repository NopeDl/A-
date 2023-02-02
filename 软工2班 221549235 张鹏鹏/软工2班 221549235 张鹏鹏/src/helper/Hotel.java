package helper;

import java.util.ArrayList;
import java.util.Scanner;

public class Hotel {

    //旅馆房间号初始化
    public static void arrayAdd(ArrayList<RoomID> array) {
        int i, g, n = 0;
        for (i = 100; i <= 500; i += 100)
            for (g = 1; g <= 8; g++) {
                switch (g) {
                    case 1, 5 -> n = 1;  //单人房
                    case 2, 6 -> n = 2;  //双床房
                    case 3, 7 -> n = 3;  //双人房
                    case 4, 8 -> n = 4;  //双层房
                }
                RoomID RID = new RoomID(i + g, 0, n);
                array.add(RID);
            }
    }

    //录入订购的房间
    public static void roomCards(ArrayList<Account> roomCards, int ID, int date) {
        Account a = new Account(ID, date);
        roomCards.add(a);
    }

    //主操作
    public static void main(String[] args) {
        ArrayList<RoomID> array = new ArrayList<>();
        ArrayList<Account> roomCards = new ArrayList<>();
        arrayAdd(array);
        Account ac = new Account();
        Discounts D = new Discounts();
        Scanner sc = new Scanner(System.in);
        Room SR = new SingleRoom();
        Room TR = new TwinRoom();
        Room DBR = new DoubleRoom();
        Room DR = new DuplexRoom();
        ac.setVIP("普通用户");
        SR.setPrice(100);
        SR.firstNumber(10);
        TR.setPrice(150);
        TR.firstNumber(10);
        DBR.setPrice(150);
        DBR.firstNumber(10);
        DR.setPrice(180);
        DR.firstNumber(10);


        System.out.println("********欢迎使用旅馆小帮手********");

        while (true) {
            System.out.println("欢迎" + ac.getVIP() + "：" + ac.getUser1() + "  当前余额：" + ac.getBalance() + "  享受折扣：" + D.special(ac.getVIP()));
            System.out.println("------1.查看空闲房间------");
            System.out.println("------2.开房------");
            System.out.println("------3.退房------");
            System.out.println("------4.查看我的房卡------");
            System.out.println("------5.充值------");
            System.out.println("------6.办卡------");
            System.out.println("------0.退出登录------");
            System.out.println("请输入操作数:>");

            int choice = sc.nextInt();
            switch (choice) {
                case 1 -> spareRoom(array);
                case 2 -> {
                    System.out.println("房间类型：");
                    System.out.println("1.单人房   剩余数量：" + SR.getNumber() + "   每晚价格：" + SR.getPrice());
                    System.out.println("2.双床房   剩余数量：" + TR.getNumber() + "   每晚价格：" + TR.getPrice());
                    System.out.println("3.双人房   剩余数量：" + DBR.getNumber() + "   每晚价格：" + DBR.getPrice());
                    System.out.println("4.双层房   剩余数量：" + DR.getNumber() + "   每晚价格：" + DR.getPrice());
                    System.out.println("请选择房间类型");
                    int rentChoice = sc.nextInt();
                    System.out.println("需要订购的房间数");
                    int rentNumber = sc.nextInt();
                    System.out.println("想住几天");
                    int day = sc.nextInt();
                    switch (rentChoice) {
                        case 1 -> {
                            if (ac.getBalance() < day * rentNumber * SR.getPrice() * D.discount(ac.getVIP())) {
                                System.out.println("您的余额已不足，请先充值");
                                break;
                            }
                            System.out.println("请选择房间号");
                            int select;
                            for (int i = 1; i <= rentNumber; i++) {
                                select = sc.nextInt();
                                selectID(array, select);
                                roomCards(roomCards, select, day);
                            }
                            SR.rentRoom(rentNumber);
                            ac.set_balance(day * rentNumber * SR.getPrice() * D.discount(ac.getVIP()));
                            ac.setSrNumber(rentNumber);
                        }
                        case 2 -> {
                            if (ac.getBalance() < day * rentNumber * TR.getPrice() * D.discount(ac.getVIP())) {
                                System.out.println("您的余额已不足，请先充值");
                                break;
                            }
                            System.out.println("请选择房间号");
                            int select;
                            for (int i = 1; i <= rentNumber; i++) {
                                select = sc.nextInt();
                                selectID(array, select);
                                roomCards(roomCards, select, day);
                            }
                            TR.rentRoom(rentNumber);
                            ac.set_balance(day * rentNumber * TR.getPrice() * D.discount(ac.getVIP()));
                            ac.setTrNumber(rentNumber);
                        }
                        case 3 -> {
                            if (ac.getBalance() < day * rentNumber * DBR.getPrice() * D.discount(ac.getVIP())) {
                                System.out.println("您的余额已不足，请先充值");
                                break;
                            }
                            System.out.println("请选择房间号");
                            int select;
                            for (int i = 1; i <= rentNumber; i++) {
                                select = sc.nextInt();
                                selectID(array, select);
                                roomCards(roomCards, select, day);
                            }
                            DBR.rentRoom(rentNumber);
                            ac.set_balance(day * rentNumber * DBR.getPrice() * D.discount(ac.getVIP()));
                            ac.setDbrNumber(rentNumber);
                        }
                        case 4 -> {
                            if (ac.getBalance() < day * rentNumber * DR.getPrice() * D.discount(ac.getVIP())) {
                                System.out.println("您的余额已不足，请先充值");
                                break;
                            }
                            System.out.println("请选择房间号");
                            int select;
                            for (int i = 1; i <= rentNumber; i++) {
                                select = sc.nextInt();
                                selectID(array, select);
                                roomCards(roomCards, select, day);
                            }
                            DR.rentRoom(rentNumber);
                            ac.set_balance(day * rentNumber * DR.getPrice() * D.discount(ac.getVIP()));
                            ac.setDbrNumber(rentNumber);
                        }
                        default -> System.out.println("暂无此类房间");
                    }
                }
                case 3 -> {
                    if (ac.getSrNumber() == 0 && ac.getTrNumber() == 0 && ac.getDbrNumber() == 0 && ac.getDrNumber() == 0) {
                        System.out.println("您并未订购任何房间");
                        break;
                    }
                    SR.checkOut(ac.getSrNumber());
                    ac.setSrNumber(0);
                    DR.checkOut(ac.getTrNumber());
                    ac.setTrNumber(0);
                    DBR.checkOut(ac.getDbrNumber());
                    ac.setDbrNumber(0);
                    DR.checkOut(ac.getDrNumber());
                    ac.setDrNumber(0);
                    for (helper.RoomID R : array)
                        for (helper.Account A : roomCards)
                            if (R.getRoomId() == A.getCards())
                                R.setStatus(0);
                    if (roomCards.size() > 0)
                        roomCards.subList(0, roomCards.size()).clear();


                    System.out.println("退房成功\n欢迎下次光临！");
                }
                case 4 -> search(roomCards);
                case 5 -> ac.topUp();
                case 6 -> {
                    if (ac.getBalance() >= 50) {
                        ac.setVIP("会员");
                        System.out.println("恭喜您成为尊贵的VIP用户");
                        ac.cardBalance();
                    } else
                        System.out.println("余额不足，请先充值");
                }
                case 0 -> {
                    System.out.println("旅途愉快，谢谢使用！");
                    System.exit(0);
                }
                default -> System.out.println("暂无此操作");
            }
        }
    }

    //查看房卡
    public static void search(ArrayList<Account> roomCards) {
        System.out.println("您的房卡：");
        for (helper.Account A : roomCards)
            System.out.println("房号：" + A.getCards() + "\t剩余时间:" + A.getDate() + "天");
    }

    //查看剩余房间
    public static void spareRoom(ArrayList<RoomID> array) {
        String name = "", status;
        System.out.println("房间号\t类型\t\t状态");
        for (helper.RoomID RID : array) {
            if (RID.getStatus() == 0)
                status = "空闲";
            else
                status = "已入住";
            switch (RID.getRoomName()) {
                case 1 -> name = "单人房";
                case 2 -> name = "双床房";
                case 3 -> name = "双人房";
                case 4 -> name = "双层房";
            }
            System.out.println(RID.getRoomId() + "\t\t" + name + "\t" + status);
        }
    }

    //开房房间选择
    public static void selectID(ArrayList<RoomID> array, int ID) {
        for (int i = 0; i < array.size(); i++) {
            RoomID RID = array.get(i);
            if (RID.getRoomId() == ID) {
                if (RID.getStatus() == 1) {
                    System.out.println("该房间已有人入住");
                } else {
                    RoomID rid = new RoomID(ID, 1, RID.getRoomName());
                    array.set(i, rid);
                }
            }
        }

    }
}
