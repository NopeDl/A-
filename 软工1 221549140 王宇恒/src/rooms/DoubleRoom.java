package rooms;

public class DoubleRoom extends Room {
    private int number;
    private String type="双人间";
    private static int price=150;
    private boolean state;
    private int day;
    private static int quantity=20;
    static SingleRoom sroom=new SingleRoom();
    private static int lastNumber=sroom.getQuantity()+quantity;
    private static int remainingNumber=20;
    public DoubleRoom(){

    }
    public DoubleRoom(int number,String type,int price,boolean state ,int day){
        this.number=number;
        this.type=type;
        this.price=price;
        this.state=state;
        this.day=day;
    }


    public int getLastNumber() {
        return lastNumber;
    }

    public void setLastNumber(int lastNumber) {
        this.lastNumber = lastNumber;
    }

    @Override
    public int getRemainingNumber() {
        return this.remainingNumber;
    }

    @Override
    public void setRemainingNumber(int remainingNumber) {
        this.remainingNumber=remainingNumber;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quatity) {
        this.quantity = quatity;
    }
    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }



    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    public boolean getState(){
        return this.state;
    }

    public String isState() {
        if(this.state)
            return"空闲";
        else
            return "已占";
    }


    public void setState(boolean state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "number=" + getNumber() +
                ", " + getType() +
                ", price=" + getPrice() +
                ", " + isState()+getDay();
    }
}
