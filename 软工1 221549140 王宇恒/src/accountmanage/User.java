package accountmanage;

public class User {
    private String str;//用户名
    private String member;//身份
    private String passward;//密码
    //构造方法，初始化
    public User() {
    }

    public User(String str, String member,String passward){
        this.str=str;
        this.member=member;
        this.passward=passward;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public String getMember() {
        return member;
    }

    public void setMember(String member) {
        this.member = member;
    }

    @Override
    public String toString() {
        return str + ","+member ;
    }

    public String getPassward() {
        return passward;
    }

    public void setPassward(String passward) {
        this.passward = passward;
    }
}
