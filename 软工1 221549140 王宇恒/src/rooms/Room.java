package rooms;

public abstract class Room {
     private int number;
     private String type;
     private int price;
     private boolean state;
     private int day;
     private int quantity;
     private int remainingNumber;

     public abstract int getRemainingNumber() ;


     public abstract void setRemainingNumber(int remainingNumber) ;


     public abstract int getQuantity() ;


     public abstract void setQuantity(int quantity);

     public abstract String getType();

     public abstract int getNumber();

     public abstract void setNumber(int number) ;


     public abstract void setType(String type) ;


     public abstract int getPrice() ;


     public abstract void setPrice(int price);

     public abstract boolean getState();

     public abstract String isState();

     public abstract void setState(boolean state);


     public abstract int getDay();


     public abstract void setDay(int day);


     public abstract int getLastNumber();

     public  abstract void setLastNumber(int lastNumber);
}
