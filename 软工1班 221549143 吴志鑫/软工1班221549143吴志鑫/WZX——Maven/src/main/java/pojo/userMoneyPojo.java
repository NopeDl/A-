package pojo;

public class userMoneyPojo {
    private String userName;
    private Integer userMoney;

    @Override
    public String toString() {
        return "userMoneyPojo{" +
                "userName='" + userName + '\'' +
                ", userMoney=" + userMoney +
                '}';
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getUserMoney() {
        return userMoney;
    }

    public void setUserMoney(Integer userMoney) {
        this.userMoney = userMoney;
    }

}
