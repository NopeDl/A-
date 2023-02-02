package hotel;

import java.util.Scanner;
//登录和注册
public class LoginSystem {
	Scanner in=new Scanner(System.in);
	private String[][] register=new String[3][3];
	private boolean allow=false;
	private double money=0.0;
	private String name;
	//
	public LoginSystem() {
		
	}
	//方法，注册
	public void registe(int numofregister) {
		System.out.println("请输入账号名：");
		String name=in.next();
		System.out.println("请输入密码：");
		String password=in.next();
		register[numofregister][0]=name;
		register[numofregister][1]=password;
		System.out.println("注册成功！");
	}
	//方法：登录
	public void login() {
		System.out.println("请输入账号名：");
		String name=in.next();
		System.out.println("请输入密码：");
		String password=in.next();
		for(int i=0;i<register.length;i++) {
			if(name.equals(register[i][0])) {
				if(password.equals(register[i][1])) {
					System.out.println("登陆成功！");
					allow=true;
					this.name=name;
					break;
				}else {
					System.out.println("账号或者密码错误！");
					break;
				}
			}else {
				System.out.println("账号或者密码错误！");
				break;
			}
		}
	}
	//得到allow，即验证是否登录
	public boolean getallow() {
		return this.allow;
	}
	//得到money
	public double getmoney() {
		return this.money;
	}
	//对money进行加法
	public double addmoney(double mon) {
		this.money+=mon;
		return this.money;
	}
	//对money进行减法
	public double losemoney(double mon) {
		this.money-=mon;
		return this.money;
	}
	//得到此时的用户名
	public String getname() {
		return this.name;
	}
}
