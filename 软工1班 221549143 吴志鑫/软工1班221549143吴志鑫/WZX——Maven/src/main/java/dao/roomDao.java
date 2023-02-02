package dao;

import pojo.roomUserPojo;

public interface roomDao {
    //添加顾客住房信息
    void addRoomUser(String name,String roomType);
    //通过顾客名字查询房间号
    roomUserPojo selectRoomNumberByUserName(String userName);
    //通过名字+房间号来确认是否为开房顾客
    roomUserPojo checkCustomByNameAndNumber(String name, Integer roomNumber);
    //删除用户住房信息（退房）
    void removeRoomRecored(String name,Integer RoomNumber);
    //根据房号查询房间的类型
    roomUserPojo selectRoomTypeByRoomNumber(Integer roomNumber);
}
