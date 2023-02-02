package src.guangjin.java.hotelsystem.app;

public abstract class Room
{
    public String type;
    private String userName;
    private int status;//房间状态，1：入住；0：空闲
    private int price;
    private int num;

    public Room() {
    }

    public Room(String type, String userName, int status, int price, int num) {
        this.type = type;
        this.userName = userName;
        this.status = status;
        this.price = price;
        this.num = num;
    }




    /**
     * 获取
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * 设置
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 获取
     * @return userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取
     * @return status
     */
    public int getStatus() {
        return status;
    }

    /**
     * 设置
     * @param status
     */
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * 获取
     * @return price
     */
    public int getPrice() {
        return price;
    }

    /**
     * 设置
     * @param price
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * 获取
     * @return num
     */
    public int getNum() {
        return num;
    }

    /**
     * 设置
     * @param num
     */
    public void setNum(int num) {
        this.num = num;
    }

    public abstract void printRoomInfoForBoss(Room room);
    public abstract void printRoomInfoForCs(Room room);
    }





