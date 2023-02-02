package src.guangjin.java.hotelsystem.app;

import java.util.ArrayList;

public abstract class User
{
    private String userName;
    private String password;
    private int userHomeNumber;
    private String judgeVip ;//会员
    private String discount ;//折扣
    private int sum;//余额
    private int count;//第几个客人

    public User() {
    }

    public User(String userName, String password, int userHomeNumber, String judgeVip, String discount, int sum, int count) {
        this.userName = userName;
        this.password = password;
        this.userHomeNumber = userHomeNumber;
        this.judgeVip = judgeVip;
        this.discount = discount;
        this.sum = sum;
        this.count = count;
    }


    public abstract void work(User usInfo, ArrayList<User> customerStateList, Room singleRoom, Room twinRoom, Room presentRoom);

    /**
     * 获取
     * @return userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取
     * @return userHomeNumber
     */
    public int getUserHomeNumber() {
        return userHomeNumber;
    }

    /**
     * 设置
     * @param userHomeNumber
     */
    public void setUserHomeNumber(int userHomeNumber) {
        this.userHomeNumber = userHomeNumber;
    }

    /**
     * 获取
     * @return judgeVip
     */
    public String getJudgeVip() {
        return judgeVip;
    }

    /**
     * 设置
     * @param judgeVip
     */
    public void setJudgeVip(String judgeVip) {
        this.judgeVip = judgeVip;
    }

    /**
     * 获取
     * @return discount
     */
    public String getDiscount() {
        return discount;
    }

    /**
     * 设置
     * @param discount
     */
    public void setDiscount(String discount) {
        this.discount = discount;
    }

    /**
     * 获取
     * @return sum
     */
    public int getSum() {
        return sum;
    }

    /**
     * 设置
     * @param sum
     */
    public void setSum(int sum) {
        this.sum = sum;
    }

    /**
     * 获取
     * @return count
     */
    public int getCount() {
        return count;
    }

    /**
     * 设置
     * @param count
     */
    public void setCount(int count) {
        this.count = count;
    }


}
