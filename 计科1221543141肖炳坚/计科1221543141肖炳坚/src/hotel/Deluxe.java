package hotel;

public class Deluxe extends Room{
	private double price=250.0;
	//构造
	public Deluxe(int roomnumber,String type,boolean state) {
		super(roomnumber,type,state);
	}
	//方法：得到该价格
	public double getprice() {
		return this.price;
	}
	@Override//重写toString
	public String toString() {
		return super.toString()+",价格："+this.price+"]";
	}
	
	
}