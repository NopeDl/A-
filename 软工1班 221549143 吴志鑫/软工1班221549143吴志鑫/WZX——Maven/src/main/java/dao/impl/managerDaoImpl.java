package dao.impl;

import dao.managerDao;
import pojo.roomPojo;
import pojo.roomUserPojo;
import pojo.surplusRoomPojo;
import unit.daoFather;
import unit.wzxSQL;
import java.util.ArrayList;
import java.util.List;

public class managerDaoImpl extends daoFather implements managerDao {
    private String sql;
    @Override
    public List<roomUserPojo> selectAllUserDao() {
        sql="select * from room_user";
        Object result = wzxSQL.useWzxSQL(sql, roomUserPojo.class);
        if (result==null)return null;
        if (!"java.util.ArrayList".equals(result.getClass().getTypeName())){
            ArrayList<roomUserPojo> roomUserPojos = new ArrayList<>();
            roomUserPojos.add((roomUserPojo) result);
            return roomUserPojos;
        }
        return (List<roomUserPojo>) result;
    }
    @Override
    public surplusRoomPojo selectSurplusRoomSum(String type) {
        sql="select * from surplus_room where room_type=?";
        Object result = wzxSQL.useWzxSQL(sql, surplusRoomPojo.class, type);
        return (surplusRoomPojo) result;
    }

    @Override
    public void updateSurplusRoomSum(String type, Integer updateSum) {
        sql="update surplus_room set surplus_number=? where room_type=?";
        wzxSQL.useWzxSQL(sql,Integer.class,updateSum,type);
    }

    @Override
    public roomPojo selectRoomSumByType(String type) {
        sql="select * from room where room_class=?";
        Object result = wzxSQL.useWzxSQL(sql, roomPojo.class, type);
        return (roomPojo) result;
    }

    @Override
    public void updateRoomSumByType(String type, Integer updateSum) {
        sql="update room set sum=? where room_class=?";
        wzxSQL.useWzxSQL(sql,Integer.class,updateSum,type);
    }

    @Override
    public List selectAllRoomsSum() {
        sql="select * from room";
        List results =(List) wzxSQL.useWzxSQL(sql, roomPojo.class);
            return results;
    }
    @Override
    public void releaseAllManDao() {
        sql="delete from room_user";
        wzxSQL.useWzxSQL(sql,Integer.class);
    }
    @Override
    public void changeSurplusRoomSumToInit(Integer firstSum, Integer secondSum, Integer thirdSum) {
        sql="update surplus_room set surplus_number=? where room_type='first'";
        wzxSQL.useWzxSQL(sql,Integer.class,firstSum);
        sql="update surplus_room set surplus_number=? where room_type='second'";
        wzxSQL.useWzxSQL(sql,Integer.class,secondSum);
        sql="update surplus_room set surplus_number=? where room_type='third'";
        wzxSQL.useWzxSQL(sql,Integer.class,thirdSum);
    }
}
