//import java.util.*;

public class Main {
    public static void main(String[] args) {

        //Scanner in = new Scanner(System.in);

        Hotel myHotel = new Hotel(10);

        System.out.println(1);

        myHotel.showAllRoom();

        myHotel.checkIn(2);
        myHotel.checkIn(1);
        myHotel.checkIn(1);
        myHotel.checkIn(3);
        myHotel.checkIn(2);
        myHotel.checkIn(1);
        myHotel.checkIn(1);
        myHotel.checkIn(3);

        myHotel.showAllRoom();



        System.out.println(2);

        myHotel.checkIn(2);
        myHotel.checkIn(1);
        myHotel.checkIn(1);
        myHotel.checkIn(3);
        myHotel.checkIn(3);
        myHotel.checkIn(3);

        myHotel.checkOut(0);
        myHotel.checkOut(3);
        myHotel.checkOut(2);
        myHotel.checkOut(6);
        myHotel.checkOut(12);

        myHotel.showAllRoom();



        System.out.println(3);

        myHotel.checkIn(2);
        myHotel.checkIn(1);
        myHotel.checkIn(1);
        myHotel.checkIn(3);
        myHotel.checkIn(3);
        myHotel.checkIn(3);

        myHotel.showAllRoom();


    }
}