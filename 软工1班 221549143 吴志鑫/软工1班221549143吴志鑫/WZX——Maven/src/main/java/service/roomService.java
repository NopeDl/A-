package service;

import java.util.Map;

//开房服务
public interface roomService {
    //开房
    Map<String,Integer> roomOppen(String roomType, String name);
    //退房
    String roomClose(String username,int roomSpot);
    //查询余额
    Integer selectBalanceService(String name);
}
