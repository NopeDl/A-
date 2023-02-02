package hotelSystem;

import java.util.Scanner;

public class controlSystem implements Service {
    Scanner sc=new Scanner(System.in);
    private int id;
    private String password;
    private String newName;
    private int roomPrice;
    Hotel h=new Hotel();
    public void check(){     //查询所有顾客信息
            h.check();
            int l=h.lengh();
            for(int i=0;i<l;i++) {
                System.out.println(h.guestName[i]);
                System.out.println(h.guest_idCard[i]);
            }
    }
    public void roomsChange(int id){//更改房间类型，房价
        System.out.println("请输入更改后的房间类型和价格 （如仅更改房价则输入房价更改的房间号）");
        newName=sc.next();
        roomPrice=sc.nextInt();
        h.roomsChange(newName,id,roomPrice);
    }


}
