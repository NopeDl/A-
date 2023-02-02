package helper;

public class RoomID {
    private final int roomId;

    private int status;
    private final int roomName;

    public int getRoomId() {
        return roomId;
    }


    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getRoomName() {
        return roomName;
    }



    public RoomID(int roomId, int status, int roomName) {
        this.roomId = roomId;
        this.status = status;
        this.roomName = roomName;
    }
}
