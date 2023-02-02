package service.impl;

import dao.MoneyDealDao;
import dao.VipDao;
import dao.impl.MoneyDealDaoImple;
import dao.impl.VipDaoImpl;
import pojo.userMoneyPojo;
import service.vipService;
import unit.daoImplFactory;
import unit.serviceFather;
import java.util.HashMap;
import java.util.Map;

public class vipServiceImpl extends serviceFather implements vipService {
    private VipDao vipDao= (VipDaoImpl) daoImplFactory.getDao("VipDaoImpl");
    private MoneyDealDao moneyDealDao=(MoneyDealDaoImple) daoImplFactory.getDao("MoneyDaoImpl");
    @Override//利用threadLocal保证同一对象+JDK动态代理设置事件
    public Map<String, Integer> beVip(String name) {
        //验证余额是否充足
        userMoneyPojo userMoneyPojo=moneyDealDao.checkMoneyDao(name);
        HashMap<String, Integer> message = new HashMap<>();
        if (userMoneyPojo==null){
            //不充足——打印“余额不足”提示，并与余额一并存入Map中返回
            message.put("余额不足",0);
            return message;
        }
        Integer balance = userMoneyPojo.getUserMoney();
        if (balance<200){
            //不充足——打印“余额不足”提示，并与余额一并存入Map中返回
            message.put("余额不足",balance);
            return message;
        }else{
            //充足，校验是否已经是Vip
            if(vipDao.isVipDao(name)!=null){
                //是Vip，打印提示语言，键值随意，一起封装到Map返回
                message.put("真实贵人多忘事！您本来就是本店的VIP~",1);
                return message;
            }else{
                //不是Vip，扣钱，纳入Vip名单，打印提示语言，键值随意，一起封装到Map返回
                moneyDealDao.updateBalance(name,userMoneyPojo.getUserMoney()-200);
                vipDao.beVip(name);
                message.put("恭喜你！成为本店至尊VIP！！！",1);
                return message;
            }
        }
    }
}
