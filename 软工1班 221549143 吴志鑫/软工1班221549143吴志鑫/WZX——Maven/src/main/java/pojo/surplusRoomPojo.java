package pojo;

public class surplusRoomPojo {
    private String roomType;
    private Integer surplusNumber;

    @Override
    public String toString() {
        return "surplusRoomPojo{" +
                "roomType='" + roomType + '\'' +
                ", surplusNumber=" + surplusNumber +
                '}';
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public Integer getSurplusNumber() {
        return surplusNumber;
    }

    public void setSurplusNumber(Integer surplusNumber) {
        this.surplusNumber = surplusNumber;
    }

}
