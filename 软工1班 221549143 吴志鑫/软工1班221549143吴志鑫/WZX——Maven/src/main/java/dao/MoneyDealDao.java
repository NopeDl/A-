package dao;

import pojo.userMoneyPojo;

public interface MoneyDealDao {
    //查询余额
    userMoneyPojo checkMoneyDao(String name);
    //开户+充值
    void addUser(String name,Integer money);
    //修改余额
    void updateBalance(String name,Integer updateToMoney);
}
