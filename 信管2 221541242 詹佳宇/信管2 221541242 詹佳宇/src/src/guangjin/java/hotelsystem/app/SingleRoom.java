package src.guangjin.java.hotelsystem.app;

public class SingleRoom extends Room
{
    public SingleRoom() {
    }

    public SingleRoom(String type, String userName, int status, int price, int num) {
        super(type, userName, status, price, num);
    }

    @Override
    public void printRoomInfoForBoss(Room singleRoom)
    {
        System.out.println("房间类型为:单人间" + " " + "房间住客名为:" + singleRoom.getUserName() + " " + "房间价格为:" + singleRoom.getPrice() + " " + "还剩下:" + singleRoom.getNum() + "间");
    }
    @Override
    public void printRoomInfoForCs(Room singleRoom)
    {
        System.out.println("房间类型为:单人间"  + " " + "房间价格为:" + singleRoom.getPrice() + " " + "还剩下:" + singleRoom.getNum() + "间");
    }
}
