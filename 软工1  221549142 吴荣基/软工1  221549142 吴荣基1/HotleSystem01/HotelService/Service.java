package HotleSystem01.HotelService;

import HotleSystem01.Hotle.model;
import HotleSystem01.Utility;
import HotleSystem01.custom.Capital;
import HotleSystem01.custom.information;

/**
 * 响应View的调用
 * 完成对房间、客户信息的各类操作（增删改查）
 */
public class Service {
    Capital excahnce = new Capital(1000, 0);

    private static information customs[] = new information[25];//利用静态多态数组

    //共有25个房间，并按先后顺序查看他们的信息
    // 假设一共有25个房间，记录25个顾客
    static int count = 0;
    private boolean pool01 = true;

    public information[] list() {//返回顾客信息
        return customs;
    }

    /**
     * 添加顾客信息
     */
    public void AddCustom() {
        System.out.println("请输入你的房间id、姓名、电话");
        System.out.println("id\t");
        int id = Utility.readInt(4);
        System.out.println("姓名");
        String name = Utility.readString(8);
        System.out.println("电话号码");
        String number = Utility.readString(16);
        information Information = new information(id, name, number);
        // 判断旅店是否住满
        if (count < 25) {
           customs[(id / 1000 + id % 10)] = Information;//这里用一维数组来代替二维数组
            count++;
        } else {
            System.out.println("旅馆已住满");
            pool01 = false;//提示顾客该旅馆已住满
        }
    }

    /**
     * 退房后，删除顾客信息
     */
    public void delCustom() {
        model M = new model();
        boolean pool02 = true;
        do{
        System.out.println("请输入你的房间id、姓名、电话");
        System.out.println("id\t");
        int id = Utility.readInt(4);
        System.out.println("姓名");
        String name = Utility.readString(8);
        System.out.println("电话号码");
        String number = Utility.readString(16);
        information Information = new information(id, name, number);
        if(customs[(id / 1000 + id % 10)].equals(Information)) {
            customs[(id / 1000 + id % 10)] = null;
            count--;
            System.out.println("退房成功");
            M.roomsigle01[id / 1000][id % 10] = "false";
            break;
        }else {
            System.out.println("核实信息不对，请重新输入");
            System.out.println("退出请按N,继续任意按其他键");
            if(Utility.readChar() == 'N'){break;}
        }
        }while (pool02);
    }

    /**
     * 退房，核实顾客信息和房间信息
     */
    public void Unsub() {
        System.out.println("请再次确认是否退房Y/N");
        if(Utility.readChar() == 'Y') {
            delCustom();
        }

    }
    //订房
    public void Book(int id) {
        //提示管理员该房间已住人
        //并给出相应的价格
        int i, j;
        i = id / 1000 - 1;
        j = id % 10 - 1;
        if (j <= 5) {
            model M = new model();
            if (M.roomsigle01.equals("false")) {
                System.out.println("该房间已有客户!");
            } else {
                System.out.println("请输入住多少晚");
                int day = Utility.readInt();
                int Aprice = 0;
                if (day == 1 || day == 2) {
                    Aprice = 300 * day;
                } else if (day == 3 || day == 4) {
                    Aprice = 500 * day;
                } else if (day == 5) {
                    Aprice = 900 * day;
                }
                System.out.println("您需要支付" + Aprice + "元");
                if (excahnce.getBcapital() >= Aprice) {

                    /**
                     * 记录顾客信息
                     */
                    AddCustom();

                    M.roomsigle01[i][j] = "false";//false表示该房间已有客户
                    System.out.println("订房成功");
                    Capital.setBcapital(Capital.getBcapital() - Aprice );
                } else {
                    System.out.println("余额不够");
                    System.out.println("订房失败");
                }
            }
        }else {
            System.out.println("请输入正确的房间号");
        }
    }

    /**
     * 如何处理交钱的问题。
     */
    public void Exchance(int price) {//假设A国是B国汇率的0.8
        excahnce.setBcapital(price * 0.8);
        excahnce.setAcapital(1000 - price * 0.8);
    }
}


