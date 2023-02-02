package hotel;

public class Single extends Room{
	private double price=100.0;
	//构造
	public Single(int roomnumber,String type,boolean state) {
		super(roomnumber,type,state);
		
	}
	//方法：得到该价格
	public double getprice() {
		return this.price;
	}
	@Override//重写通String
	public String toString() {
		return super.toString()+",价格："+this.price+"]";
	}
	
}
