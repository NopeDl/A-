package unit;
import service.impl.managerServiceImpl;
import service.impl.roomServiceImpl;
import service.impl.topupServiceImpl;
import service.impl.vipServiceImpl;

public class serviceImplFactory {
    public static serviceFather getImpl(String fileType){
        //通过工厂分发对象，降低耦合度
        if("managerServiceImpl".equals(fileType)){
            return new managerServiceImpl();
        } else if ("roomServiceImpl".equals(fileType)) {
            return new roomServiceImpl();
        } else if ("topupServiceImpl".equals(fileType)) {
            return new topupServiceImpl();
        } else if ("vipServiceImpl".equals(fileType)) {
            return new vipServiceImpl();
        }else{
            throw new RuntimeException("没有此对象！");
        }
    }
}
