package dao;

import pojo.roomPojo;
import pojo.roomUserPojo;
import pojo.surplusRoomPojo;

import java.util.List;
import java.util.Map;

public interface managerDao {
    //查询所有用户入住信息
    List<roomUserPojo> selectAllUserDao();
    //查询剩余某类型房间数
    surplusRoomPojo selectSurplusRoomSum(String type);
    //修改剩余某类型房间的数量
    void updateSurplusRoomSum(String type,Integer updateSum);
    //查询某类型房间总数
    roomPojo selectRoomSumByType(String type);
    //修改某类型房间的总数
    void updateRoomSumByType(String type,Integer updateSum);
    //查询旅馆所有的房间数据
    List selectAllRoomsSum();
    //将顾客全部驱散
    void releaseAllManDao();
    //将剩余房间的数量全部还原为房间总数
    void changeSurplusRoomSumToInit(Integer firstSum, Integer secondSum, Integer thirdSum);
}
