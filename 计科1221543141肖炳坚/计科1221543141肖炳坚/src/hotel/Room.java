package hotel;

public class Room {
	//Single,Double,Deluxe的父类
	private int roomnumber;
	private String type;
	private boolean state;
	
	//构造
	public Room(int roomnumber,String type,boolean state) {
		this.roomnumber=roomnumber;
		this.type=type;
		this.state=state;
	}
	//重写toString
	@Override
	public String toString() {
		return "Room ["+this.roomnumber+","+this.type+","+(this.state?"空闲":"占用");
	}
	//方法
	//得到房间号
	public int getroomnumber() {
		return this.roomnumber;
	}
	//得到居住情况是否空闲
	public boolean getstate() {
		return this.state;
	}
	//改变居住情况
	public void setstate(boolean state) {
		this.state=state;
	}
	//得到价格，子类有一样的方法
	public double getprice() {
		return 0;
	}
	
}
