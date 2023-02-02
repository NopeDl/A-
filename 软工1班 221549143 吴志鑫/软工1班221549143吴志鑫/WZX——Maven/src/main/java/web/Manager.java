package web;
import pojo.roomUserPojo;
import unit.proxyUtil;
import unit.serviceImplFactory;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Manager {
    private static Scanner scanner = new Scanner(System.in);
    private static Reception reception=new Reception();
    private static service.managerService managerService=(service.managerService) proxyUtil.newProxyInstance( serviceImplFactory.getImpl("managerServiceImpl"));
    public void check(){
        System.out.print("请输入管理员密码确认身份：");
        if("630".equals(scanner.next())){
            //确认为管理员
            System.out.println("老板好~~请问有什么吩咐？");
            manager();
        }else{
            //假冒管理员
            System.out.println("来人！把这小贼给我拖出去'教育'一下!!！");
        }
    }
    /*
     * 管理员操作
     * */
    public void manager(){
            System.out.println("A.查询所有用户入住信息   B.建造房间  C.拆除房间  D.装修房间   E.查询各类房间数量   F.切换用户");
            String purpose = scanner.next();
            switch (purpose) {
                case "A":selectAllUser();break;
                case "B":buildRoom();break;
                case "C":removeRoom();break;
                case "D":decorateRoom();break;
                case "E":selectRooms();break;
                case "F":reception.changeUser();break;
                default:
                    System.out.println("抱歉老板！请重新录入大写且唯一的英文选项字母！");
                    manager();
            }
    }
    /*
     *查询所有用户入住信息
     */
    public void selectAllUser(){
        List<roomUserPojo> roomUserPojos = managerService.selectAllUser();
        if (roomUserPojos != null) {
            //不为空
            System.out.println("老板，所有用户入住信息如下：");
            for (roomUserPojo roomUserPojo : roomUserPojos) {
                System.out.println(roomUserPojo);
            }
            selectContinue();
        }else{
            System.out.println("老板啊，生意惨淡！一个客人都没有....");
            selectContinue();
        }
    }
    /*
    * 建造房间
    * */
    public void buildRoom(){
        System.out.println("好的!老板,你要建什么类型的房间？A.普通房  B.精品套房  C.总统套房");
        String BuildRoomType= reception.typeChange(reception.checkDataType(scanner.next()));
        System.out.println("建多少间？");
        int BuildRoomSum=0;
        try {
            BuildRoomSum = scanner.nextInt();
        } catch (Exception e){
            System.out.println("来捣乱是吧？！给我时光倒流！！！！重新来");
            buildRoom();
        }
        managerService.buildRoom(BuildRoomType,BuildRoomSum);
        System.out.println("建造完成！！！");
        selectContinue();
    }
    /*
    * 拆除房间
    * */
    public void removeRoom(){
        managerService.realseAllMan();
        System.out.println("好嘞，为了安全着想，我这就疏散所有住客...搞定!老板,你要拆什么类型的房间？A.普通房  B.精品套房  C.总统套房");
        //查询房间数
        Map<String, Integer> AllRooms = managerService.selectAllRooms();
        System.out.println("目前，普通房有" + AllRooms.get("first") + "间，精品套房有" + AllRooms.get("second") + "间，总统套房有" + AllRooms.get("third") + "间");
        String deleteRoomType= reception.typeChange(reception.checkDataType(scanner.next()));
        System.out.println("拆多少间？");
        int deleteRoomSum= 0;
        try {
            deleteRoomSum = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("来捣乱是吧？！给我时光倒流！！！！重新来");
           removeRoom();
        }
        String message = managerService.deleteRoom(deleteRoomType, deleteRoomSum);
        System.out.println(message);
        selectContinue();
    }
    /*
    * 装修房间
    * */
    public void decorateRoom(){
        System.out.println("好嘞，为了安全着想，我这就疏散所有住客");
        managerService.realseAllMan();
        System.out.println("搞定!老板,你要装修一间什么类型的房间？A.普通房  B.精品套房");
        String fromRoomType= scanner.next();
        while(!"A".equals(fromRoomType)&&!"B".equals(fromRoomType)){
            System.out.println("抱歉老板！请重新录入大写且唯一的英文选项字母！");
            fromRoomType=scanner.next();
        }
        if("A".equals(fromRoomType)){
            System.out.println("老板，你要把普通房装修为什么类型？B.精品套房 C.总统套房");
            String toRoomType= reception.checkDataType(scanner.next());
            if ("A".equals(toRoomType)){
                System.out.println("老板别闹，你把普通房装修成普通房有啥意思,你想清楚先~");
                selectContinue();
            }
            String message = managerService.decorateRoomService(reception.typeChange(fromRoomType), reception.typeChange(toRoomType));
            System.out.println(message);
            selectContinue();
        } else if ("B".equals(fromRoomType)) {
            managerService.decorateRoomService("second","third");
            System.out.println("装修完成！！！");
            selectContinue();
        }
    }
    /*
    * 查询各类房间数量
    * */
    public void selectRooms(){
        Map<String, Integer> AllRooms = managerService.selectAllRooms();
        System.out.println("目前，普通房有" + AllRooms.get("first") + "间，精品套房有" + AllRooms.get("second") + "间，总统套房有" + AllRooms.get("third") + "间");
        selectContinue();
    }
    //常用语句块——看老板还要不要继续操作
    public void selectContinue(){
        System.out.println("老板还有没有吩咐？（回复Y/N）");
        String k=scanner.next();
        if("Y".equals(k))
            manager();
        else if ("N".equals(k))
            System.out.println("老板慢走~~~~");
        else {
            System.out.println("抱歉老板！请重新录入大写且唯一的英文选项字母！");
            selectContinue();
        }
    }
}
