package src.guangjin.java.hotelsystem.app;

public class TwinRoom extends Room
{
    public TwinRoom() {
    }

    public TwinRoom(String type, String userName, int status, int price, int num) {
        super(type, userName, status, price, num);
    }

    @Override
    public void printRoomInfoForBoss(Room twinRoom)
    {
        System.out.println("房间类型为:双人间" + " " + "房间住客名为:"
                + twinRoom.getUserName() + " " + "房间价格为:" + twinRoom.getPrice() + " " + "还剩下:" + twinRoom.getNum() + "间");

    }
    @Override
    public void printRoomInfoForCs(Room twinRoom)
    {
        System.out.println("房间类型为:双人间" + " " + "房间价格为:" + twinRoom.getPrice() + " " + "还剩下:" + twinRoom.getNum() + "间");
    }
}
