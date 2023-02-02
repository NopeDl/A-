package HotleSystem00;

import HotleSystem01.HotelService.Service;
import HotleSystem01.Hotle.model;
import HotleSystem01.Utility;
import HotleSystem01.custom.information;

/**
 * 默认管理员操作，非多用户
 * 显示界面
 * 接收用户的输入
 * 调用HotelService完成对旅馆信息的各种操作
 */
public class View  {
    private static boolean pool = true;
    private Service service = new Service();
    private String key;

  public void Serinformation(String key){
      if(key.equals("Y")) {//用”==“出现了问题
          information[] informations = service.list();
          //得到顾客所有的信息
          for(int i = 0;i<informations.length;i++){
            if(informations[i] == null){//如果为空不用显示
                  break;
                  }
              System.out.println(informations[i]);
          }
          System.out.println("显示完毕");
      }
  }
    public void view00(){
        do {
            System.out.println("============== WELCOME =============");
            System.out.println("================ 旅馆 ===============");
            System.out.println("| 1、查询房间         2 、订房        |");
            System.out.println("| 3、退房            4、兑换货币      |");
            System.out.println("| 5、退出系统                        |");
            System.out.println("==========请输入你的选择（1-5）========");
            switch (Utility.readInt(5)){
                case 1:
                    System.out.println("查询");
                    model.Rooms2();
                    System.out.println("============================\t");
                    System.out.println("Y/N要查询已住顾客信息,");
                    Serinformation(Utility.readString(1,"N"));

                    break;
                case 2:
                    System.out.println("订房");
                    System.out.println("请输入您想要的房间号");
                    service.Book(Utility.readInt(4));
                    break;
                case 3:
                    System.out.println("退房");
                   service.Unsub();

                    break;
                case 4:
                    System.out.println("兑换");
                    System.out.println("您需要兑换多少钱");
                    service. Exchance(Utility.readInt(1000));
                    //假设小爪有1000A元
                    break;
                case 5:
                    System.out.println("退出");
                    pool = false;
                    break;
                default: System.out.println("请输入正确的号码");//异常处理
            }
            System.out.println("\t\t");
        }while (pool);

    }
}
