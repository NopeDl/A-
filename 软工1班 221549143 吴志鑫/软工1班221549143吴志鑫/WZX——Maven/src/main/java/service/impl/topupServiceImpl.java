package service.impl;

import dao.MoneyDealDao;
import dao.impl.MoneyDealDaoImple;
import pojo.userMoneyPojo;
import service.topupService;
import unit.daoImplFactory;
import unit.serviceFather;

//充值服务
public class topupServiceImpl extends serviceFather implements topupService {
    private MoneyDealDao moneyDealDao=(MoneyDealDaoImple) daoImplFactory.getDao("MoneyDaoImpl");
    @Override //利用threadLocal保证同一对象+JDK动态代理设置事件
    public void topUp(String name, int money) {
        //先判断对方是否是新客（表中没有他的数据）
        userMoneyPojo userMoneyPojo=moneyDealDao.checkMoneyDao(name);
        if(userMoneyPojo==null){
            //是，插入名字+money新数据存入user_money表
            moneyDealDao.addUser(name,money);
        }else{
            //不是，直接在user_money表money数据添加数据
            moneyDealDao.updateBalance(name,userMoneyPojo.getUserMoney()+money);
        }
    }
}
