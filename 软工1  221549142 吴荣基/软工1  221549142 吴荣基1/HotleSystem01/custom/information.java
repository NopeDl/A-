package HotleSystem01.custom;

/**
 * 利用封装，和修饰符来修饰用户信息
 */
public class information {
       private int id;//住几号房间
       private String name;
       private String number;

    public information(int id, String name, String number) {
        this.id = id;
        this.name = name;
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "已住顾客 id=" + id +
                ", name=" + name  +
                ", number=" + number+"\t  " ;
    }
}
