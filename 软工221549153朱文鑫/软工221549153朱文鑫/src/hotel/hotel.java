package hotel;

import customers.customer;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @Auther: zhaoss
 * @Date: 2023/1/9 - 01 - 09 - 22:07
 * @Description: hotel
 * @version: 1.0
 */
public class hotel {
    HashMap<Integer,room> map=new HashMap<>();//酒店房间集合
    room room=new room();
    static int i=30;
    customer customer=new customer();
    Scanner sc=new Scanner(System.in);
    //数组下标为房间编号
    public hotel(){
        for (int i = 0; i <30 ; i++) {
            if (0 <= i && i < 10) {
                map.put(i, new room(i, "单人间", true));
            }
            if (10<=i&&i<20){
                map.put(i, new room(i, "标准间", true));
            }
            if (20<=i&&i<30){
                map.put(i, new room(i, "双人间", true));
            }
        }
    }
    public void userInfo(int id){
        System.out.println("用户信息：");
        room room1 = map.get(id);
        System.out.println("用户所住房间:"+room1.getId()+"号房;"+room1.getType()+";余额为："+customer.getNowMoney());
    }
    //遍历 查看房间状态
    public void print(){
        for(int i=0;i<30;i++){
            if(i%10==0){
                System.out.println();
            }
            room room = map.get(i);
            System.out.print(room);
        }
        System.out.println();
        System.out.println("单人间价格为100;标准间价格为150;双人间价格为200");
    }
    public void order(int id){//预定房间
        room room2 = map.get(id);
        boolean status = room2.isStatus();
        if (!status) {
            System.out.println("这间房已经被预定过了,请重新预定");
            return;}
        int temp;
        System.out.println("单人间价格为100;标准间价格为150;双人间价格为200");
        while (true) {
             if (customer.vip()){
                System.out.println("请输入所需房间付款钱币：");
                int i = sc.nextInt();
                int nowMoney = customer.getNowMoney();
                if (i==100) {
                    if (nowMoney >= (int) (100*0.8)) {
                        temp = (int) ((int) 100 * 0.8);
                        nowMoney -= temp;
                        customer.setNowMoney(nowMoney);
                        System.out.println("八折优惠，当前余额为："+customer.getNowMoney());
                        room room1 = map.get(id);
                        room1.setStatus(false);
                        System.out.println(id + "号房，已被订！");//被占用了
                        return;
                    }else {
                        System.out.println("对不起,你的余额不足,请充值后再订房");
                        return;
                    }
                }
                if (i==150) {
                    if (nowMoney>=(int)(150*0.8)){
                    temp= (int) ((int)150*0.8);
                    nowMoney-=temp;
                    customer.setNowMoney(nowMoney);
                    System.out.println("八折优惠，当前余额为："+customer.getNowMoney());
                    room room1 = map.get(id);
                    room1.setStatus(false);
                    System.out.println(id + "号房，已被订！");//被占用了
                    return;
                    }else {
                        System.out.println("对不起,你的余额不足,请充值后再订房");
                        return;
                    }
                }if (i==200) {
                    if (nowMoney>(int) (200*0.8)){
                    temp= (int) ((int)200*0.8);
                    nowMoney-=temp;
                    customer.setNowMoney(nowMoney);
                    System.out.println("八折优惠，当前余额为："+customer.getNowMoney());
                    room room1 = map.get(id);
                    room1.setStatus(false);
                    System.out.println(id + "号房，已被订！");//被占用了
                    return;
                    }else {
                        System.out.println("对不起,你的余额不足,请充值后再订房");
                        return;
                    }
                }if(nowMoney<(int) (150*0.8)){
                    System.out.println("对不起,你的余额不足,请充值后再订房");
                    return;
                }
                else {
                    System.out.println("你输入的支付钱币有误，请重新输入！");
                }
            }else {
                while (true){
                customer.exchangeMoney();
                System.out.println("请输入所需房间付款钱币：");
                int i = sc.nextInt();
                int nowMoney = customer.getNowMoney();
                if (i==100){
                    if(nowMoney>=100){
                    nowMoney-=100;
                    customer.setNowMoney(nowMoney);
                    System.out.println("当前余额为："+customer.getNowMoney());
                    room room1 = map.get(id);
                    room1.setStatus(false);
                    System.out.println(id + "号房，已被订！");//被占用了
                    return;}else {
                        System.out.println("对不起，你当前的余额不足,订房失败！");
                        return;
                    }
                }else if (i==150){
                    if (nowMoney>=150){
                    nowMoney-=150;
                    customer.setNowMoney(nowMoney);
                    System.out.println("当前余额为："+customer.getNowMoney());
                    room room1 = map.get(id);
                    room1.setStatus(false);
                    System.out.println(id + "号房，已被订！");//被占用了
                    return;}else {
                        System.out.println("对不起，你当前的余额不足,订房失败！");
                        return;
                    }
                }else if (i==200){
                    if (nowMoney>=200){
                    nowMoney-=200;
                    customer.setNowMoney(nowMoney);
                    System.out.println("当前余额为："+customer.getNowMoney());
                    room room1 = map.get(id);
                    room1.setStatus(false);
                    System.out.println(id + "号房，已被订！");//被占用了
                    return;}else {
                        System.out.println("对不起，你当前的余额不足,订房失败！");
                        return;
                    }
                }else if (i<100){
                    System.out.println("对不起，你输入的订房价格有误，请重新输入");
                    return;
                }
            }
            }
        }
    }
    public void exit(int id){//退房
        room room1 = map.get(id);
        room1.setStatus(true);//房间空闲
        System.out.println(id+"号房，已退房！");
    }
    public void setRoom(HashMap<Integer,room> map){//建造房间
        System.out.println("请输入你想建造的房间,例如：1：单人间，2：标准间，3：双人间");
        int choose = sc.nextInt();
        while (true){
            if(choose==1){
                map.put(i,new room(i,"单人间",true));
                i++;
                System.out.println("成功建造一间单人间！");
                return;
            }
            if(choose==2){
                map.put(i,new room(i,"标准间",true));
                i++;
                System.out.println("成功建造一间标准间！");
                return;
            }
            if(choose==1){
                map.put(i,new room(i,"双人间",true));
                i++;
                System.out.println("成功建造一间双人间！");
                return;
            }else {
                System.out.println("你输入有误，请重新输入");
            }
        }
    }
}
