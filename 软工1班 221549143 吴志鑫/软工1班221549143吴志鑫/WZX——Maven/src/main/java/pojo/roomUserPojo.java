package pojo;

public class roomUserPojo {
    private String userName;
    private Integer roomNumber;
    private String roomClass;


    @Override
    public String toString() {
        return "roomUserPojo{" +
                "userName='" + userName + '\'' +
                ", roomNumber=" + roomNumber +
                ", roomClass='" + roomClass + '\'' +
                '}';
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getRoomClass() {
        return roomClass;
    }

    public void setRoomClass(String roomClass) {
        this.roomClass = roomClass;
    }
}
