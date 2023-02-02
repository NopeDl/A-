package hotel;

/**
 * @Auther: zhaoss
 * @Date: 2023/1/9 - 01 - 09 - 21:32
 * @Description: hotel
 * @version: 1.0
 */
public class room {
    private int id;//房间编号
    private String type;//房间类型

    private boolean status;//房间状态，true为空闲，false为占用了

    public room() {
    }

    public room(int id,String type,boolean status) {
        this.id = id;
        this.type=type;
        this.status=status;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isStatus() {
        return status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof room)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        room room = (room) obj;
        return this.id == room.id;
    }

    @Override
    public String toString() {
        return "("+id+","+type+","+(status?"空闲":"占用");
    }
}
