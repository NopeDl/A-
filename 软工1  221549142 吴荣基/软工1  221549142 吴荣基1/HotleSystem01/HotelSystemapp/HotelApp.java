package HotleSystem01.HotelSystemapp;

import HotleSystem01.HotelView.View;
import HotleSystem01.Hotle.model;

public  class HotelApp {
        //创建房间，并进行初始化
    public static void hotelApp(){
        model.Rooms0();
        model.Rooms1();
         new View().view();//利用虚对象来调用View类的view方法
        System.out.println("你退出了系统");
          }
    }
