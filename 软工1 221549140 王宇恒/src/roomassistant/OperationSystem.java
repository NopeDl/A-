package roomassistant;

import accountmanage.AccountNumber;
import accountmanage.User;
import rooms.Hotel;

import java.util.*;

public class OperationSystem {
    //主操作界面
    public static void main(String[] args) {
        Hotel hotel = new Hotel();
        //利用HashMap集合来实现账号转换和会员判断
        AccountNumber acn=new AccountNumber();
        HashMap<String, User> account = new HashMap<>();//创建账户集合
        HashMap<String,Double>money=new HashMap<String, Double>();
        HashMap<String,Integer>room=new HashMap<String, Integer>();
        account.put("a", new User("张三", "会员", "123"));
        account.put("b", new User("张四", "管理员", "456"));
        account.put("c", new User("张五", "用户", "789"));
        money.put("a",1000.0);
        money.put("b",0.0);
        money.put("c",111.0);

        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("*********欢迎使用旅馆小助手************");
            System.out.println("-----------请输入账号名--------------");
            String str = scan.next();
            acn.isMember(str, account,money);
            if(acn.getBool()) {
                System.out.println("-----------1.查看房间状况--------------");
                System.out.println("-----------2.开房-------------");
                System.out.println("-----------3.退房-------------");
                System.out.println("-----------4.查看我的房卡---------------");
                System.out.println("-----------5.充值-------------");//充，都可以充
                System.out.println("-----------6.查询所有用户入住信息-------------");
                System.out.println("-----------7.建造、拆除、装修、设总数量-------------");
                System.out.println("-----------8.办卡-------------");
            }
                System.out.println("-----------0.退出登录------------------");
                System.out.println("请输入操作数：>");
            int i = scan.nextInt();
            if (i == 1&&acn.getBool()) {
                hotel.showRooms();
            } else if (i == 2&&acn.getBool()) {
                hotel.show();
                System.out.println("请输入想开的房间类型:>");
                String type = scan.next();
                System.out.println("要住几天捏:>");
                int day = scan.nextInt();
                room.put(str,hotel.openRooms(type, day));
                if(account.get(str).getMember().equals("会员"))
                money.replace(str,money.get(str)-day* hotel.price(type)*0.8);
                else
                    money.replace(str,money.get(str)-day* hotel.price(type));

            } else if (i == 3&&acn.getBool()) {
                System.out.println("请输入您要退的房间编号:>");
                int number = scan.nextInt();
                hotel.outRooms(number);
                room.remove(str);//退房删数据
            } else if (i == 4&&acn.getBool()) {//看房卡
                System.out.println(room.get(str));
            } else if (i == 5&&acn.getBool()) {
                System.out.println("请输入要充的账号");
                String userName = scan.next();
                if(account.get(userName).getMember().equals("会员")) {
                    System.out.println("请输入充值数额");
                    Double recharge = scan.nextDouble();
                    money.replace(userName, recharge + money.get(userName));
                }
                else
                    System.out.println("该账号不是会员");
            } else if (i == 6&&acn.getBool()) {//查询所有账户
                if (account.get(str).getMember().equals("管理员")&&acn.getBool()){
                    //存到Set集合
                    Set<HashMap.Entry<String, User>> set = account.entrySet();
                    //遍历Set集合
                    Iterator<HashMap.Entry<String, User>> it = set.iterator();
                    while (it.hasNext()) {
                        HashMap.Entry<String, User> entry = it.next();
                        String key = entry.getKey();
                        User value = entry.getValue();
                        if (!account.get(key).getMember().equals("管理员"))
                            System.out.println(key + "," + value+","+room.get(key));
                    }
                } else
                    System.out.println("您不是管理员");
            } else if (i == 7&&acn.getBool()) {
                if (account.get(str).getMember().equals("管理员")&&acn.getBool()) {
                System.out.println("请输入具体操作（如“建造”)");
                String actor=scan.next();
                System.out.println("请输入数量");
                int number=scan.nextInt();
                System.out.println("请输入类型（若为装修则输两种类型）");
                String type1=scan.next();
                if(actor.equals("建造")) {
                    hotel.setUpRooms(type1, number);
                }else if(actor.equals("拆除")) {
                    hotel.removeRooms(type1, number);
                }else if (actor.equals("装修")) {
                    String type2 = scan.next();
                    hotel.changeRooms(type1, type2, number);
                } else if(actor.equals("设总数量")) {
                        hotel.setRooms(type1,number);
            } }} else if (i == 8&&acn.getBool()) {
                if(account.get(str).getMember().equals("用户")) {
                    account.get(str).setMember("会员");
                    money.put(str, 0.0);
                    System.out.println("办卡成功");
                }
                else
                    System.out.println("你无法办卡");
            } else if (i == 0) {
                System.out.println("**************************************************");
                System.out.print("退出系统，");
                System.out.println("欢迎下次使用");
                System.out.println("**************************************************");
                return;
            }
            else {
                System.out.println("您未成功登录，无法使用系统功能");
            }
        }

    }
}




