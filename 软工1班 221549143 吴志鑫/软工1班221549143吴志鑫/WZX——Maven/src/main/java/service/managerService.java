package service;

import pojo.roomUserPojo;

import java.util.List;
import java.util.Map;

//管理员特权
public interface managerService {
    //查询所有用户入住信息
    List<roomUserPojo> selectAllUser();
    //建造房间
    void buildRoom(String buildRoomType, Integer BuildRoomSum);
    //查询房间总数
    Map<String,Integer> selectAllRooms();
    //拆除房间
    String deleteRoom(String deleteRoomType, Integer deleteRoomSum);
    //装修房间
    String decorateRoomService(String fromRoomType, String toRoomType);
    //疏散所有顾客
    void realseAllMan();
}
