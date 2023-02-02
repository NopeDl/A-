package dao.impl;

import dao.roomDao;
import pojo.roomUserPojo;
import unit.daoFather;
import unit.wzxSQL;
public class roomDaoImpl extends daoFather implements roomDao{
    private String sql;
    @Override
    public void addRoomUser(String name,String roomType) {
        sql="insert into room_user(user_name,room_class) values(?,?)";
        wzxSQL.useWzxSQL(sql,Integer.class,name,roomType);
    }
    @Override
    public roomUserPojo checkCustomByNameAndNumber(String name, Integer roomNumber) {
        sql="select * from room_user where user_name=? and room_number=?";
        Object result = wzxSQL.useWzxSQL(sql, roomUserPojo.class, name, roomNumber);
        return (roomUserPojo) result;
    }

    @Override
    public void removeRoomRecored(String name, Integer RoomNumber) {
        sql="delete from room_user where user_name=? and room_number=?";
        wzxSQL.useWzxSQL(sql, roomUserPojo.class, name, RoomNumber);
    }

    @Override
    public roomUserPojo selectRoomTypeByRoomNumber(Integer roomNumber) {
        sql="select * from room_user where room_number=?";
        Object result = wzxSQL.useWzxSQL(sql, roomUserPojo.class, roomNumber);
        return (roomUserPojo)result;
    }

    @Override
    public roomUserPojo selectRoomNumberByUserName(String userName) {
        sql="select * from room_user where user_name=?";
        Object result = wzxSQL.useWzxSQL(sql, roomUserPojo.class, userName);
        return (roomUserPojo)result;
    }
}
