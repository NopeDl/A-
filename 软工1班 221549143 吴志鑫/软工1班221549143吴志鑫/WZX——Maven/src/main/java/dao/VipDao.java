package dao;

import pojo.vipPojo;

public interface VipDao {
    //判断是否为Vip
    vipPojo isVipDao(String name);
    //设置为VIP
    void beVip(String name);
}
