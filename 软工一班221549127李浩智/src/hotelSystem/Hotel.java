package hotelSystem;

import controlSystem.databaseConnect;

import java.util.Scanner;

    public class Hotel implements Service {
        //用二维数组来定义房间
        //在这里调用Room定义的类
        Scanner sc = new Scanner(System.in);
        private Rooms[][] rooms;
        private String idName,idCard;
        static String guestName[]=new String[43];
        static String[] guest_idCard=new String[43];
        static int guestMoney=0;
        //Hotel h=new Hotel();    //定义hotel对象
        public Hotel() {
            rooms = new Rooms[4][10];//现在每个房间里面的都是null，还没赋值
            for (int i = 0; i < rooms.length; i++) {
                for (int j = 0; j < rooms[i].length; j++) {
                    if (i == 0)
                        rooms[i][j] = new Rooms((i + 1) * 100 + j + 1, "单人间", true, 700);
                    if (i == 1)
                        rooms[i][j] = new Rooms((i + 1) * 100 + j + 1, "双人间", true, 1300);
                    if (i == 2)
                        rooms[i][j] = new Rooms((i + 1) * 100 + j + 1, "单人间", true, 700);
                    if (i == 3)
                        rooms[i][j] = new Rooms((i + 1) * 100 + j + 1, "双人间", true, 1300);
                }
            }
        }

        //打印房间状态
        //遍历二维数组
        public void check() {
            for (int i = 0; i < rooms.length; i++) {
                for (int j = 0; j < rooms[i].length; j++) {
                    System.out.print(rooms[i][j]);
                }
                System.out.println();
            }
        }

        public int lengh(){
            return this.rooms.length;
        }

        public void charge(int guestCharge){
            guestMoney=guestMoney+guestCharge;
            System.out.println("您的账户还有"+guestMoney);
        }

        public int guestMoney(){
            return this.guestMoney;
        }
        public void vipPay(){
            Hotel h1=new Hotel();
            h1.charge(-1688);
            System.out.println("您的vip账号为");
        }
        public void order(int id,String idCard,String guestName) {
            Rooms room1 =rooms[id / 100 - 1][id % 100 - 1];
            room1.setStatus(false);
            Hotel pay=new Hotel();
            for(int i=0;i< rooms.length;i++){
                this.guestName[i]=guestName;
                this.guest_idCard[i]=idCard;
            }
            if(id/100==1||id/100==3)
                pay.charge(-700);
            else
                pay.charge(-1300);
        }
        public void exit(int id){
            Rooms room2 =rooms[id / 100 - 1][id % 100 - 1];
            room2.setStatus(true);
        }
        public void roomsChange(int id){
            Hotel h1=new Hotel();
            h1.exit(id);
            h1.check();
            if(id/100==1||id/100==3)
                h1.charge(700);
            else
                h1.charge(1300);
            System.out.println("请输入您想更换的房间号：");
            int newRoom=sc.nextInt();
            h1.order(newRoom);//调用下面的方法
            h1.check();
        }
        public void order(int id) {    //方法重载
             Rooms room1 =rooms[id / 100 - 1][id % 100 - 1];
            room1.setStatus(false);
            Hotel pay=new Hotel();
            if(id/100==1||id/100==3)
                pay.charge(-700);
            else
                pay.charge(-1300);
        }

        public void roomsChange(String newName,int id,int roomPrice){
                Rooms room5=rooms[id / 100 - 1][id % 100 - 1];
                room5=new Rooms(id,newName, true,roomPrice);
                System.out.println("更改成功,新房间为"+room5);
            }
    }


