package helper;

import java.util.Scanner;

public class Account {
    private final String user1 = "Rocs";
    private double balance;         //余额

    private int srNumber;
    private int trNumber;
    private int dbrNumber;
    private int drNumber;
    private int cards;
    private int date;
    private String VIP;

    public String getVIP() {
        return VIP;
    }

    public void setVIP(String VIP) {
        this.VIP = VIP;
    }

    public int getDate() {
        return date;
    }

    public Account(int cards, int date) {
        this.cards = cards;
        this.date = date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getCards() {
        return cards;
    }

    public void setCards(int cards) {
        this.cards = cards;
    }

    public int getSrNumber() {
        return srNumber;
    }

    public void setSrNumber(int srNumber) {
        this.srNumber = srNumber;
    }

    public int getTrNumber() {
        return trNumber;
    }

    public void setTrNumber(int trNumber) {
        this.trNumber = trNumber;
    }

    public int getDbrNumber() {
        return dbrNumber;
    }

    public void setDbrNumber(int dbrNumber) {
        this.dbrNumber = dbrNumber;
    }

    public int getDrNumber() {
        return drNumber;
    }

    public void setDrNumber(int drNumber) {
        this.drNumber = drNumber;
    }

    public Account() {
    }

    public double getBalance() {
        return balance;
    }

    //充值使得余额增加
    public void setBalance(double balance) {
        this.balance += balance;
    }

    //开房使得余额减少
    public void set_balance(double balance){
        this.balance -= balance;
    }
    //办卡使得余额减少
    public void cardBalance(){
        this.balance -= 50;
    }

    public String getUser1() {
        return user1;
    }

    //充值操作
    public void topUp() {
        System.out.println("请输入需要充值的数额");
        Scanner sc = new Scanner(System.in);
        double m = sc.nextInt();
        setBalance(m);
        System.out.println("充值成功");
    }
}
