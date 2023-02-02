package hotelSystem;

import java.util.Objects;

    public class Rooms {
        private int id;//房间编号

        private String type;//房间类型

        private boolean status;//房间是否空闲

        private int price;//房间价格

        public Rooms() {    //无参构造器
        }

        public Rooms(int id, String type, boolean status,int price) {
            this.id = id;
            this.type = type;
            this.status = status;
            this.price = price;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public boolean isStatus() {
            return status;
        }

        public void setStatus(boolean status) {
            this.status = status;
        }

        public int getPrice() {return price;}

        public void setPrice(int price) {this.price = price;}
        //对equals方法的重写
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Rooms room = (Rooms) o;
            return id == room.id &&
                    status == room.status &&
                    Objects.equals(type, room.type);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, type, status);
        }
        //对toString方法的重写
        @Override
        public String toString() {
            return "{" + "房间号：" + id + ','+"类型：" + type + ", " + "状态："+(status?"空闲":"占用") +","+"价格："+ price+ '}';
        }
    }




