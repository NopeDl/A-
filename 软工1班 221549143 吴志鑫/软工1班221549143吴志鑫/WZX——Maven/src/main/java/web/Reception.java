package web;
import service.managerService;
import service.topupService;
import unit.proxyUtil;
import unit.serviceImplFactory;
import java.util.Map;
import java.util.Scanner;

public class Reception {
    private static service.roomService roomService=(service.roomService) proxyUtil.newProxyInstance( serviceImplFactory.getImpl("roomServiceImpl"));
    private static topupService topUpService=(topupService) proxyUtil.newProxyInstance(serviceImplFactory.getImpl("topupServiceImpl")) ;
    private static service.vipService vipService=(service.vipService) proxyUtil.newProxyInstance( serviceImplFactory.getImpl("vipServiceImpl"));
    private static String name;
    private static Manager manager=new Manager();
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.print("欢迎光临爪哇旅馆!请先登记您的名字：");
        name = scanner.next();
        if("wzx".equals(name)){
            manager.check();
        }else{
            System.out.println("请问您需要什么服务？");
            Reception reception = new Reception();
            reception.mainService(name);
        }
    }
    public void mainService(String name){
            System.out.println("A.充值本地货币  B.开房  C.退房  D.办理本店至尊VIP卡  E.为本店房间数提建议  F.查询余额  G.切换账户 (管理员功能请看我的上手文档来开启)");
            switch (scanner.next()) {
                case "A":toUp();break;
                case "B":roomOppen();break;
                case "C":roomClose();break;
                case "D":Vip();break;
                case "E":getSuggetions();break;
                case "F":selectUserBalance();break;
                case "G":changeUser();break;
                default:
                    System.out.println("抱歉！请重新录入大写且唯一的英文选项字母！");
                    mainService(name);
            }
        }
    /*
    * 充值操作
    * */
    public void toUp(){
        System.out.print("请输入你需要充值的金额：");
        Integer money=null;
        try {
            money=scanner.nextInt();
        } catch (Exception e) {
            System.out.println("不会吧，不会吧，还有人这样输金额？！给我重新输");
          isToUp();
        }
        topUpService.topUp(name,money);
        System.out.println("充值成功！！！");
        this.isContinue();
    }
    /*
     * 开房操作
     * */
    public void roomOppen(){
        System.out.println("客官~你真有眼光，一眼就知道咱儿店好~");
        System.out.println("我们店有三种类型的房间，分别是:A.普通单间 60￥/晚   B.精品套房 150￥/晚   C.总统套房 350￥/晚");
        System.out.print("请大声说出你的梦中情房编号：");
        Map resultMessage = roomService.roomOppen(typeChange(checkDataType(scanner.next())), name);
        System.out.println("太帅了!小爪这就为你办理~~");
        if(resultMessage.keySet().contains("余额不足")){
            //余额不足
            System.out.println("客官，你的本地货币余额不足....[尴尬].jpg");
            System.out.println("你的余额为" + resultMessage.get(resultMessage.keySet()));
           isToUp();
        }else if(resultMessage.keySet().contains("开房成功！！！")||resultMessage.keySet().contains("很遗憾，本店有钱多，一个人只能开一间房~")){
            //开房成功
            System.out.println(resultMessage.keySet()+"您如今的房间号为"+resultMessage.get(resultMessage.keySet().toArray()[0]));
            System.out.println("请问你是否还需要其他服务？（回复Y/N）");
            if("Y".equals(scanner.next()))
                mainService(name);
            else
                System.out.println("好的~希望你居住愉快！！！");
        }else{
            //没有多余房间了
            System.out.println(resultMessage.keySet()+"该类型房间剩余量为:"+resultMessage.get(resultMessage.keySet()));
            isContinue();
        }
    }
    /*
    * 退房操作
    * */
    public  void roomClose(){
        System.out.print("请问您要退的房间的号码是：");
        String message=roomService.roomClose(name,scanner.nextInt());
        System.out.println(message);
        isContinue();
    }
    /*
    * Vip
    * */
    public void Vip(){
        System.out.println("客官您真有品味~本店的Vip卡200￥/张,这就为您办理..");
        Map<String, Integer> result = vipService.beVip(name);
        if(result.keySet().contains("余额不足")){
            //余额不足
            System.out.println("客官，你的本地货币余额不足....[尴尬].jpg");
            System.out.println("你的余额为" + result.get(result.keySet()));
            isToUp();
    }else{
            System.out.println(result.keySet());
            this.isContinue();
        }
    }
    /*
    * 为本店房间数提建议
    * */
    public void getSuggetions(){
        System.out.println("你觉得我们有所都短缺的房型是：A.普通房  B.精品套房  C.总统套房");
        managerService managerService =(service.managerService) proxyUtil.newProxyInstance( serviceImplFactory.getImpl("managerServiceImpl"));
        managerService.buildRoom(typeChange(checkDataType(scanner.next())),5);
        System.out.println("好的！感谢你的反馈！");
        isContinue();
    }
    /*
    * 切换账户
    * */
    public  void changeUser(){
        System.out.print("请问您的名字是：");
        name= scanner.next();
        if("wzx".equals(name)){
            manager.check();
        }else{
            System.out.println("请问您需要什么服务？");
            mainService(name);
        }
    }
    /*
    * 查询个人余额
    * */
    public void selectUserBalance(){
        Integer balance = roomService.selectBalanceService(name);
        System.out.println("您的余额为："+balance);
        isContinue();
    }
    //是否充值？
    public  void isToUp(){
        System.out.println("请问您是否要充值？（回复Y/N）");
        String k=scanner.next();
        if("Y".equals(k)){
            toUp();
        }
        else if ("N".equals(k)){
            System.out.println("好的吧...【委屈】.jpg");
            isContinue();
        }
        else{
            System.out.println("抱歉！请重新录入大写且唯一的英文选项字母！");
            isToUp();
        }
    }
    //是否继续操作？
    public  void isContinue(){
        System.out.println("请问你是否还需要其他服务？（回复Y/N）");
        String k=scanner.next();
        if("Y".equals(k)){
            mainService(name);
        }else if ("N".equals(k)){
            System.out.println("好的，欢迎下次光临！");
        }else{
            System.out.println("抱歉！请重新录入大写且唯一的英文选项字母！");
            isContinue();
        }
    }
    //房间类型字母对应转换
    public  String typeChange(String letter){
     switch (letter){
        case "A":return "first";
        case "B":return "second";
        case "C":return "third";
        default:
            System.out.println("你别捣乱！");
            throw new RuntimeException("再见~~");
    }
    }
    //判断录入数据是否符合规范
    public  String checkDataType(String data){
        if ("A".equals(data)||"B".equals(data)||"C".equals(data)){
            return data;
        }else{
            System.out.println("抱歉！请重新录入大写且唯一的英文选项字母！");
            return checkDataType(scanner.next());
        }
    }
}
