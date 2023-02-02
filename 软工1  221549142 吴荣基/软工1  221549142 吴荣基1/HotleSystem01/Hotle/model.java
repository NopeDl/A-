package HotleSystem01.Hotle;

/**
 * 要不要继续查询房间，查看对顾客的信息？
 */
public class model {
    //假设旅店有5层，每层有个房间
    //利用静态
        static int rooms[][] = new int[5][5];
        public static String roomsigle01[][] = new String[5][5];
         public static void Rooms0() {
             for (int i = 0; i < 5; i++) {
                 for (int j = 0; j < 5; j++) {
                     rooms[i][j] = (i + 1) * 1000 + j;
                 }
             }
         }
        public static void Rooms1() {
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    roomsigle01[i][j] = "[true]";
                }
            }
        }

        public static void Rooms2 () {
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    System.out.print(rooms[i][j] + roomsigle01[i][j] + " ");
                }
                System.out.print("\n");
            }
            System.out.println("一、二层为单人间，价格为300元每晚");
            System.out.println("三、四层为双人间，价格为500元每晚");
            System.out.println("五层为总统套房，价格为900元每晚");

        }

}
