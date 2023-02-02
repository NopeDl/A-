package service.impl;

import dao.MoneyDealDao;
import dao.impl.MoneyDealDaoImple;
import dao.impl.managerDaoImpl;
import dao.impl.roomDaoImpl;
import dao.managerDao;
import dao.roomDao;
import pojo.userMoneyPojo;
import service.roomService;
import unit.daoImplFactory;
import unit.serviceFather;
import java.util.HashMap;
import java.util.Map;

//开房服务
public class roomServiceImpl extends serviceFather implements roomService {
    private roomDao roomDao=(roomDaoImpl) daoImplFactory.getDao("roomDaoImpl");
    private managerDao managerDao=(managerDaoImpl) daoImplFactory.getDao("managerDaoImpl");
    private MoneyDealDao moneyDealDao=(MoneyDealDaoImple) daoImplFactory.getDao("MoneyDaoImpl");
    @Override    //利用threadLocal保证同一对象+JDK动态代理设置事件
    public Map<String, Integer> roomOppen(String roomType, String name) {
        Map<String, Integer> map = new HashMap<>();
        //判断目标房型是否还有空余
        Integer thisTypeRoomSum=managerDao.selectSurplusRoomSum(roomType).getSurplusNumber();
        if (thisTypeRoomSum>0){
            //有空余
            int needMoney=0;
            //验证余额是否充足
            switch (roomType){
                case "first":needMoney=60;break;
                case "second":needMoney=150;break;
                case "third":needMoney=350;break;
            }
            userMoneyPojo userMoneyPojo=moneyDealDao.checkMoneyDao(name);
            if (userMoneyPojo==null){
                //不充足——打印“余额不足”提示，并与余额一并存入Map中返回
                map.put("余额不足",0);
                return map;
            }
            if(userMoneyPojo.getUserMoney()>=needMoney){
                //充足——判断是否已经开房
                if(roomDao.selectRoomNumberByUserName(name)!=null){
                    Integer hisRoomSpotNumber = roomDao.selectRoomNumberByUserName(name).getRoomNumber();
                    //是——打印信息和房间号返回
                    map.put("很遗憾，本店有钱多，一个人只能开一间房~",hisRoomSpotNumber);
                    return map;
                }else{
                // 不是——余额削减  +   剩余房间消减  +   客户在线房间数据加一  +   打印提示语和房间号返回
                moneyDealDao.updateBalance(name,userMoneyPojo.getUserMoney()-needMoney);
                managerDao.updateSurplusRoomSum(roomType,thisTypeRoomSum-1);
                roomDao.addRoomUser(name,roomType);
                Integer hisRoomSpotNumber = roomDao.selectRoomNumberByUserName(name).getRoomNumber();
                map.put("开房成功！！！",hisRoomSpotNumber);
                return map;
                }
            }else{
                //不充足——打印“余额不足”提示，并与余额一并存入Map中返回
                map.put("余额不足",userMoneyPojo.getUserMoney());
                return map;
            }
        }else {
            //没有空余,打印结果信息+0封装为Map返回
            map.put("客官，很抱歉！",0);
            return map;
        }
    }

    @Override
    public String roomClose(String username, int roomSpot) {
       //验证该顾客的名字和房间号是否属实
        if(roomDao.checkCustomByNameAndNumber(username,roomSpot)!=null){
            //属实——房间在线数据-1  + 剩余可用房间+1  +   返回提示语
            //根据房间号查询什么类型
            String roomType = roomDao.selectRoomTypeByRoomNumber(roomSpot).getRoomClass();
            managerDao.updateSurplusRoomSum(roomType,managerDao.selectSurplusRoomSum(roomType).getSurplusNumber()+1);
            roomDao.removeRoomRecored(username,roomSpot);
            return "退房成功!";
        }else{
            //不属实——返回提示语
            return "很抱歉!你并未开通这个房间！";
        }
    }

    @Override
    public Integer selectBalanceService(String name) {
        userMoneyPojo userMoneyPojo = moneyDealDao.checkMoneyDao(name);
        if (userMoneyPojo != null) {
            return userMoneyPojo.getUserMoney();
        }else {
            return 0;
        }
    }
}
