package unit;

import dao.impl.*;

public class daoImplFactory {
    public static daoFather getDao(String fileType){
        //通过工厂分发对象，降低耦合度
        if("managerDaoImpl".equals(fileType)){
            return new managerDaoImpl();
        } else if ("roomDaoImpl".equals(fileType)) {
            return new roomDaoImpl();
        } else if ("VipDaoImpl".equals(fileType)) {
            return new VipDaoImpl();
        } else if ("MoneyDaoImpl".equals(fileType)) {
                return new MoneyDealDaoImple();
        } else{
            throw new RuntimeException("没有此对象！");
        }
    }
}
