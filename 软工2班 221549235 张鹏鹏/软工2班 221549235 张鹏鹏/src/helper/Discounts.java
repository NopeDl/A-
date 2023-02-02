package helper;

public class Discounts {
    public double discount(String vip) {
        if (vip.equals("会员"))
            return 0.8;
        else
            return 1;
    }
    public String special(String vip){
        if (vip.equals("会员"))
            return "8折";
        else
            return "无";
    }
}
