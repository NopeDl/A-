package HotleSystem00;
import HotleSystem01.HotelSystemapp.HotelApp;
import HotleSystem01.Hotle.model;

public class Hotelapp00 extends HotelApp {//继承父类原本有的方法，相当
                                         // 于管理员系统是普通用户系统的子类
    public static void hotelApp(){
        model.Rooms0();
        model.Rooms1();
      new View().view00();
        System.out.println("你退出了系统");
    }
}

