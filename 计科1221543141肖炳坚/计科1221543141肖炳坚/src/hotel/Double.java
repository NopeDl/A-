package hotel;

public class Double extends Room{
	private double price=150.0;
	//构造
	public Double(int roomnumber,String type,boolean state) {
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
	
	
