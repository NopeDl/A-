package rooms;

public class SingleRoom extends Room {
    private int number;
    private String type="单人间";
    private static int price=100;
    private boolean state;
    private int day;
    private static int quantity=10;
    private static int remainingNumber=10;
    private  static int lastNumber=10;
    public SingleRoom(){

    }
    public SingleRoom(int number,String type,int price,boolean state,int day ){
        this.number=number;
        this.type=type;
        this.price=price;
        this.state=state;
        this.day=day;
    }

    @Override
    public int getLastNumber(){
        return this.lastNumber;
    }


    @Override
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

    @Override
    public int getQuantity() {
        return this.quantity;
    }

    @Override
    public void setQuantity(int quantity) {
        this.quantity=quantity;
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
        return
                "number=" + getNumber() +
                ", " + getType() +
                ", price=" + getPrice() +
                ", " + isState()+getDay();
    }
}
