package rooms;

public class Hotel {
    private  Room[] rooms = new Room[100];
    private static Room singleRoom = new SingleRoom();
    private static Room doubleRoom = new DoubleRoom();
    private static int amount = singleRoom.getQuantity() + doubleRoom.getQuantity();

    //构造方法，初始化数据
    public Hotel() {
        for (int i = 0; i < amount; i++) {
            if (i < singleRoom.getLastNumber())
                rooms[i] = new SingleRoom(i, "单人间", 100, true, 0);
            else if (i < doubleRoom.getLastNumber())
                rooms[i] = new DoubleRoom(i, "双人间", 150, true, 0);
        }
    }

    //展示房间信息
    public void showRooms() {
        Room[] rooms3 =resetRooms(amount);
        for (int i = 0; i < amount; i++) {
            if (i % 10 == 0)
                System.out.println();
            System.out.print(rooms3[i].toString());
            System.out.print("\t");
        }
        System.out.println();
    }



    //开房展示
    public void show(){
        Room singleRoom = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        System.out.println("房间类型："+singleRoom.getType()+"\t"+"剩余数量"+singleRoom.getRemainingNumber() +"每晚价格"+singleRoom.getPrice());
        System.out.println("房间类型："+doubleRoom.getType()+"\t"+"剩余数量"+doubleRoom.getRemainingNumber() +"每晚价格"+doubleRoom.getPrice());
    }
    //返回房价
    public int price(String type){
        if(type.equals(singleRoom.getType())) {
            return singleRoom.getPrice();
        } else if(type.equals(doubleRoom.getType())){
            return doubleRoom.getPrice();
        }
        return 0;
    }
//开房实现
    public  int openRooms(String type,int day) {
        if(type.equals(singleRoom.getType())) {
            singleRoom.setRemainingNumber(singleRoom.getRemainingNumber() - 1);
            for (int i=0;i<singleRoom.getQuantity();i++) {
                if(rooms[i].getState()) {
                    rooms[i].setState(false);
                    rooms[i].setDay(day);
                    System.out.println("开房成功");
                    return rooms[i].getNumber();
                }
            }
        }
        else if(type.equals(doubleRoom.getType())) {
            doubleRoom.setRemainingNumber(doubleRoom.getRemainingNumber() - 1);
            for (int i=singleRoom.getLastNumber();i<doubleRoom.getLastNumber();i++) {
                if(rooms[i].getState()) {
                    rooms[i].setState(false);
                    rooms[i].setDay(day);
                    System.out.println("开房成功");
                    return rooms[i].getNumber();
                }
            }
        }
        return 0;
    }
    //退房
    public void outRooms(int number){
        if(!rooms[number].getState()){
        rooms[number].setState(true);
        rooms[number].setDay(0);
        if(rooms[number].getType().equals(singleRoom.getType())) {
            singleRoom.setRemainingNumber(singleRoom.getRemainingNumber() + 1);
            }
        else if(rooms[number].getType().equals(doubleRoom.getType())) {
            singleRoom.setRemainingNumber(doubleRoom.getRemainingNumber() + 1);
        }
        System.out.println("退房成功");
        System.out.println("欢迎下次光临");}
        else
            System.out.println("没有该房间");
        }


    //新置房间
    public Room[] resetRooms(int newAmount){
        Room[] rooms2=new Room[newAmount];
        Room singleRoom = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        for (int i = 0; i < newAmount; i++) {
                if (i < singleRoom.getLastNumber()) {
                    rooms2[i] = new SingleRoom(i, "单人间", 100, true, 0);
                }
                else if (i < doubleRoom.getLastNumber()) {
                    rooms2[i] = new DoubleRoom(i, "双人间", 150, true, 0);
                }
            }


        return rooms2;
    }
    //更新对象（地址）
    public void reSet(){
         Room singleRoom = new SingleRoom();
         Room doubleRoom = new DoubleRoom();
         singleRoom.setLastNumber(singleRoom.getQuantity());
         doubleRoom.setLastNumber(singleRoom.getLastNumber()+doubleRoom.getQuantity());
         singleRoom.setRemainingNumber(singleRoom.getQuantity());
         doubleRoom.setRemainingNumber(doubleRoom.getQuantity());
         this.amount = singleRoom.getQuantity() + doubleRoom.getQuantity();
    }

    //建房
    public void setUpRooms(String type,int number){
        if(type.equals(singleRoom.getType())){
            singleRoom.setQuantity(singleRoom.getQuantity()+number);
            System.out.println("新建了"+number+"间"+type);
        }
        else if(type.equals(doubleRoom.getType())){
            doubleRoom.setQuantity(doubleRoom.getQuantity()+number);
            System.out.println("新建了"+number+"间"+type);
        }
        else{
            System.out.println("无效操作");
            return;
        }
        reSet();//取新地址
        resetRooms(amount);
    }
    //拆房
    public void removeRooms(String type,int number){
        if(type.equals(singleRoom.getType())){
            singleRoom.setQuantity(singleRoom.getQuantity()-number);
            System.out.println("拆了"+number+"间"+type);
        }
        else if(type.equals(doubleRoom.getType())){
            doubleRoom.setQuantity(doubleRoom.getQuantity()-number);
            System.out.println("拆了"+number+"间"+type);
        }
        else{
            System.out.println("无效操作");
            return;
        }
        reSet();
       resetRooms(amount);
    }
    //改房间
    public void changeRooms(String type2,String type,int number){
        if(type.equals(singleRoom.getType())&&type2.equals(doubleRoom.getType())){
            singleRoom.setQuantity(singleRoom.getQuantity()+number);
            System.out.println("成功装修");
            doubleRoom.setQuantity(doubleRoom.getQuantity()-number);
        }
        else if(type.equals(doubleRoom.getType())&&type2.equals(singleRoom.getType())){
            doubleRoom.setQuantity(doubleRoom.getQuantity()+number);
            System.out.println("成功装修");
            singleRoom.setQuantity(singleRoom.getQuantity()-number);
        }
        else{
            System.out.println("无效操作");
            return;
        }
        reSet();
        resetRooms(amount);
    }
    //设数量
    public void setRooms(String type,int number) {
        if (type.equals(singleRoom.getType())) {
            doubleRoom.setLastNumber(doubleRoom.getLastNumber() - (singleRoom.getQuantity() - number));
            singleRoom.setQuantity(number);
            System.out.println("设置成功");
        }
        else if(type.equals(doubleRoom.getType())) {
            doubleRoom.setQuantity(number);
            doubleRoom.setLastNumber(doubleRoom.getQuantity()+singleRoom.getLastNumber());
            System.out.println("设置成功");
        }
        else{
            System.out.println("无效操作");
            return;
        }
        reSet();
        resetRooms(amount);

    }

}







