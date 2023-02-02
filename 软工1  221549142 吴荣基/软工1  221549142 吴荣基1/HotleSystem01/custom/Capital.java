package HotleSystem01.custom;

public class Capital {
    private static double Acapital ;
    private static double Bcapital ;

    public  Capital(double acapital, double bcapital) {
        Acapital = acapital;
        Bcapital = bcapital;
    }

    public static double getAcapital() {
        return Acapital;
    }

    public static void setAcapital(double acapital) {
        Acapital = acapital;
    }

    public static double getBcapital() {
        return Bcapital;
    }

    public static void setBcapital(double bcapital) {
        Bcapital = bcapital;
    }
}
