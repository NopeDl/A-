/**
 * 方法：
 * 1.打印提示语
 *
 * 状态：
 * 1.房间名字
 * 2.每晚价格
 * 3.是否入住
 *
 */

public class Room {

    private String name = "Room";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    private int price = 0;

    public int getOccupied() {
        return occupied;
    }

    public void setOccupied(int occupied) {
        this.occupied = occupied;
    }

    private int occupied = 0;

    public Room(String name, int price, int occupied) {
        this.name = name;
        this.price = price;
        this.occupied = occupied;
    }

    public void printClew() {
        System.out.println("Welcome to visit next time!");
    }

    public void sayHi() {
        System.out.printf("%s costs %d yuan a night", getName(), getPrice());
    }

}
