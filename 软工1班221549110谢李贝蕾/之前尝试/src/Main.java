import java.util.*; //为什么其他类不用写这句话

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        IndexRobot eva = new IndexRobot(in); //为什么不能public

        System.out.println("Master, your name please...");

        String name = in.nextLine();

        eva.setMaster(name);

        eva.indexBook();

        eva.operation();

    }
}