package src.guangjin.java.hotelsystem.app;

public class PresentRoom extends Room
{
    public PresentRoom() {
    }

    public PresentRoom(String type, String userName, int status, int price, int num) {
        super(type, userName, status, price, num);
    }

    @Override
    public void printRoomInfoForBoss(Room presentRoom)
    {
        System.out.println("房间类型为:总统套房" + " " + "房间住客名为:"
                + presentRoom.getUserName() + " " + "房间价格为:" + presentRoom.getPrice() + " " + "还剩下:" + presentRoom.getNum() + "间");
    }
    @Override
    public void printRoomInfoForCs(Room presentRoom)
    {
        System.out.println("房间类型为:双人间"  + " " + "房间价格为:" + presentRoom.getPrice() + " " + "还剩下:" + presentRoom.getNum() + "间");
    }
}
