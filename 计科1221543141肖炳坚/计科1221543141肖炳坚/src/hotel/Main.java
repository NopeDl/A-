package hotel;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LoginSystem login=new LoginSystem();
		Hotel hotel=new Hotel();
		finish:
		while(true) {
			System.out.println("****欢迎使用旅馆小帮手****");
			System.out.println("----1."+(login.getallow()?"退出登录":"登录")+"----");
			System.out.println("----2.开房----");
			System.out.println("----3.退房----");
			System.out.println("----4.查看我的房卡----");
			System.out.println("----5.充值----");
			System.out.println("----6.注册----");
			System.out.println("----7.查看房间----");
			System.out.println("**************");
			Scanner in=new Scanner(System.in);
			int x=in.nextInt();
			switch(x) {
				case 1:
					if(!(login.getallow())) {
						login.login();
						break;
					}
					else {
						break finish;
					}
				case 2:
					if(login.getallow()) {
						System.out.println("请输入要入住的房间号：");
						int y=in.nextInt();
						if(login.getmoney()-hotel.getprice(y)>=0.0){
							hotel.order(y);
							login.losemoney(hotel.getprice(y));
						}else {
							System.out.println("请先充值");
						}
					}else {
						System.out.println("请先登录");
					}
					break;
				case 3:
					if(login.getallow()) {
						int y=in.nextInt();
						hotel.exit(y);
					}
					break;
				case 4:
					System.out.println("账号："+login.getname()+"金额："+login.getmoney());
					break;
				case 5:
					System.out.println("请输入充值的金额：");
					double mon=in.nextDouble();
					login.addmoney(mon);
					break;
				case 6:
					int numofregister=0;
					login.registe(numofregister);
					numofregister++;
					break;
				case 7:
					hotel.printRoom();
					break;
				default:
					System.out.println("请输入正确的操作数");
					break;
			}
		}
		
	}

}
