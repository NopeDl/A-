/**
 *方法：
 * 1.管理员账户登录后 展示所有房间相关信息 y
 * 2.管理员账户登录后 增加房间 y
 *
 * 3.根据用户需求建造、装修房间（允许修改数组中的房间类型） y
 *
 * 4.为当前登录用户 充值换币 n
 * 5.展示房间类型和数量 n
 * 6.开房/退房 y
 *
 *状态：
 * 1.拥有房间
 */
public class Hotel
{

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    private int total;

    public int getOccupiedNumber() {
        return occupiedNumber;
    }

    public void setOccupiedNumber(int occupiedNumber) {
        this.occupiedNumber = occupiedNumber;
    }

    private int occupiedNumber = 0;

    public Hotel(int total){
        this.total = total;
    }

    private Room[] roomList = new Room[10000];

    public void printRoom(int num, String name, int price, int occupied) {
        System.out.print("num\t\tname\t\tprice\t\t");
        if (occupied == 1) {
            System.out.println("Occupied");
        }
        else {
            System.out.println("Unoccupied");
        }
    }

    public void showAllRoom() {

        System.out.printf("The total number of rooms we currently have is %d.\n", total);
        System.out.printf("The number of rooms that have been accommodated is %d.\n", occupiedNumber);

        for (int i = 0; i <= getTotal(); i++) {
            printRoom(i, roomList[i].getName(), roomList[i].getPrice(), roomList[i].getOccupied());
        }

    }

    public void addRoom(int addNumber) {
        setTotal(getTotal() + addNumber);
    }

    public void pushRoom(Room newRoom) {

        newRoom.printClew();

        if (getOccupiedNumber() == getTotal()) {
            setTotal(getTotal() + 1);
            setOccupiedNumber(getOccupiedNumber() + 1);
            roomList[getTotal()] = newRoom;
        }

        else {
            for (int i = 0; i <= getTotal(); i++) {
                if (roomList[i].getOccupied() == 0) {
                    roomList[i] = newRoom;
                    setOccupiedNumber(getOccupiedNumber() + 1);
                }
            }
        }

    }

    public void checkIn(int number) {

        //Single
        if (number == 1) {
            SingleRoom newRoom = new SingleRoom("SingleRoom", 270, 1);
            pushRoom(newRoom);
        }

        //Double
        if (number == 2) {
            DoubleRoom newRoom = new DoubleRoom("DoubleRoom", 320, 1);
            pushRoom(newRoom);
        }

        //Twin
        if (number == 3) {
            TwinRoom newRoom = new TwinRoom("TwinRoom", 300, 1);
            pushRoom(newRoom);
        }



    }

    public void checkOut(int roomNumber) {
        roomList[roomNumber].setOccupied(0);
        roomList[roomNumber].printClew();
    }

}
