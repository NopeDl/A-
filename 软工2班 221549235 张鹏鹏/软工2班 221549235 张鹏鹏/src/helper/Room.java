package helper;

public abstract class Room implements OperateRoom {
    private int number;
    private int price;


    public int getNumber() {
        return number;
    }

    public void firstNumber(int number) {
        this.number = number;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    //租用使得房间数减少
    public void setNumber(int number) {
        this.number -= number;
        System.out.println("订购成功，欢迎入住");
    }

    //退房使得房间数增加
    public void set_number(int number){
        this.number += number;
    }

    @Override
    public void rentRoom(int number) {
        setNumber(number);
    }

    @Override
    public void checkOut(int number) {
        set_number(number);
    }

    public Room() {
    }

}
