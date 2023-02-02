package pojo;

public class roomPojo{
    private String roomClass;
    private Integer sum;//不设置int，采用包装类能避免空指针异常

    @Override
    public String toString() {
        return "roomPojo{" +
                "roomClass='" + roomClass + '\'' +
                ", sum=" + sum +
                '}';
    }

    public String getRoomClass() {
        return roomClass;
    }

    public void setRoomClass(String roomClass) {
        this.roomClass = roomClass;
    }

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }

}
