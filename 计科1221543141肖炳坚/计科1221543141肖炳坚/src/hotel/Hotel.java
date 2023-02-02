package hotel;

public class Hotel {
	private Room[][] rooms;
	//初始化数组
	public Hotel() {
		this.rooms=new Room[3][10];
		for(int i=0;i<rooms.length;i++) {
			for(int j=0;j<rooms[i].length;j++) {
				if(i==0) rooms[i][j]=new Single((i+1)*100+j+1,"单人间",true);
				if(i==1) rooms[i][j]=new Double((i+1)*100+j+1,"双人间",true);
				if(i==2) rooms[i][j]=new Deluxe((i+1)*100+j+1,"豪华间",true);
			}
		}
	}
	//打印信息
	public void printRoom() {
		for(int i=0;i<rooms.length;i++) {
			for(int j=0;j<rooms[i].length;j++) {
				System.out.print(rooms[i][j]);
			}
			System.out.println();
		}
	}
	//得到对应房间的价格
	public double getprice(int roomnumber) {
		int i=roomnumber/100-1;
		int j=roomnumber%100-1;
		return rooms[i][j].getprice();
	}
	//订房
	public void order(int roomnumber) {
		int i=roomnumber/100-1;
		int j=roomnumber%100-1;
		if(i>rooms.length||j>rooms[i].length) {
			System.out.println("房间不存在");
		}
		Room room=rooms[i][j];
		if(!(room.getstate())) {
			System.out.println("订房失败，房间已被预订");
		}else {
			room.setstate(false);
			System.out.println("订房成功，房间号为"+room.getroomnumber());
		}
		
	}
	//退房
	public void exit(int roomnumber) {
		int i=roomnumber/100;
		int j=roomnumber%100;
		if(i>rooms.length||j>rooms[i].length) {
			System.out.println("房间不存在");
			return;
		}
		Room room=rooms[i][j];
		if((room.getstate())) {
			System.out.println("退房失败，该房间是空房");
			return;
		}
		room.setstate(true);
		System.out.println("退房成功，房间号为"+room.getroomnumber());
		
	}

}
