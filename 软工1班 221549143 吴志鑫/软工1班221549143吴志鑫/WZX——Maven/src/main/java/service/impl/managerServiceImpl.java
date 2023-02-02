package service.impl;
import dao.impl.managerDaoImpl;
import dao.managerDao;
import pojo.roomPojo;
import pojo.roomUserPojo;
import service.managerService;
import unit.daoImplFactory;
import unit.serviceFather;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//管理员特权
public class managerServiceImpl extends serviceFather implements managerService {//利用threadLocal保证同一对象+JDK动态代理设置事件
    private managerDao managerDao=(managerDaoImpl) daoImplFactory.getDao("managerDaoImpl");
    @Override
    public List<roomUserPojo> selectAllUser() {
       //查询user_room用户表封装所有数据返回
        return managerDao.selectAllUserDao();
    }
    @Override
    public void buildRoom(String buildRoomType, Integer BuildRoomSum) {
        //剩余可用房间数据加    +   总房间数+
        managerDao.updateSurplusRoomSum(buildRoomType,managerDao.selectSurplusRoomSum(buildRoomType).getSurplusNumber()+BuildRoomSum);
        managerDao.updateRoomSumByType(buildRoomType,managerDao.selectRoomSumByType(buildRoomType).getSum()+BuildRoomSum);
    }

    @Override
    public Map<String, Integer> selectAllRooms() {
        //查询所有房间数据返回
        Map<String, Integer> map = new HashMap<String, Integer>();
        List results = managerDao.selectAllRoomsSum();
        int i = 0;
        while (results.size() != 0) {
            roomPojo roomPojo = (roomPojo) results.get(i);
            map.put(roomPojo.getRoomClass(), roomPojo.getSum());
            results.remove(i);
        }
        return map;
    }

    @Override
    public String deleteRoom(String deleteRoomType, Integer deleteRoomSum) {
        //获取该类型的房间总数
        Integer thisTypeRoomSum = managerDao.selectRoomSumByType(deleteRoomType).getSum();
        if(thisTypeRoomSum>=deleteRoomSum){
            //总数大于或等于拆除数：剩余可用房间数据削减    +   总房间数削减     +   打印结果信息
            managerDao.updateSurplusRoomSum(deleteRoomType,thisTypeRoomSum-deleteRoomSum);
            managerDao.updateRoomSumByType(deleteRoomType,thisTypeRoomSum-deleteRoomSum);
            return "拆除成功啦！！！";
        }else{
            //总数小于拆除数：打印结果信息
            return "老板你别闹！你哪有那么多房间拆？";
        }
    }

    @Override
    public String decorateRoomService(String fromRoomType, String toRoomType) {
        //获取该类型的被装修和目标型房间总数
        Integer fromTypeRoomSum = managerDao.selectRoomSumByType(fromRoomType).getSum();
        Integer toTypeRoomSum = managerDao.selectRoomSumByType(toRoomType).getSum();
        if(fromTypeRoomSum!=0){
            //总数不为0——当前类型的房间数总数以及其剩余房间数-1     目标类型的房间数总数以及其在线可用房间数+1  打印信息
            managerDao.updateSurplusRoomSum(fromRoomType,fromTypeRoomSum-1);
            managerDao.updateRoomSumByType(fromRoomType,fromTypeRoomSum-1);
            managerDao.updateSurplusRoomSum(toRoomType,toTypeRoomSum+1);
            managerDao.updateRoomSumByType(toRoomType,toTypeRoomSum+1);
            return "装修成功啦！！！";
        }else{
            //总数为0——打印信息
            return "老板你别闹！你哪有那么多房间装修？";
        }

    }

    @Override
    public void realseAllMan() {
        //清除在线客户的中所有的数据
        managerDao.releaseAllManDao();
        //将剩余房间还原为总值
        Integer firstSum = managerDao.selectRoomSumByType("first").getSum();
        Integer secondSum = managerDao.selectRoomSumByType("second").getSum();
        Integer thirdSum = managerDao.selectRoomSumByType("third").getSum();
        managerDao.changeSurplusRoomSumToInit(firstSum,secondSum,thirdSum);
    }

}
