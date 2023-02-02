package hotelSystem;

abstract class Pay {
    private int guestCharge;
    abstract void charge(int guestCharge);
    abstract void vipPay();
    //abstract void groupPay();
}
