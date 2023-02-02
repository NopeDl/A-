import java.util.*;

/**
 * 方法：提供索引，提供服务
 * 状态：master的名字*
 * user:xlbl
 */

public class IndexRobot {

    private Scanner in = null;

    public IndexRobot(Scanner in) {
        this.in = in;
    }

    public String getMaster() {
        return master;
    }

    public void setMaster(String masterster) {
        this.master = master;
    }

    private String master;

    public void indexBook() {
        System.out.printf("Here's %s's Task-list.\n", getMaster());
        System.out.println("[0] Show the Task-list");
        System.out.println("[1] Add Task");
        System.out.println("[2] Finish Task");
        System.out.println("[3] Show the unfinished Tasks");
        System.out.println("[4] Show the finished Tasks");
        System.out.println("[5] Keyword Search - Task's Name");
        System.out.println("[6] Keyword Search - Task's Comment");
        System.out.println("[7] Date Search - Task's CreateTime");
        System.out.println("[8] Keyword Search - Task's FinishTime");
        System.out.println("[9] Priority Search - Task's Rank");
        System.out.println("[#] Show Me Index");
        System.out.println("[*] Exit");
    }

    public TaskList list = new TaskList();

    char ch;

//    Scanner in = new Scanner(System.in);

    public void operation() {
        while (true) {
            System.out.println("Please Enter the choice");
            ch = in.next().charAt(0);
            if (ch == '*') break;
            switch (ch) {
                case '0':
                    list.showAllTasks();
                    break;

                case '1':
                    System.out.println("Please Enter Task's Name, create time(YYYY-MM-DD), " +
                            "comment and rank with line break"); //添加到未完成的项目

                    String name = in.next(); //""
                    String time = in.next();
                    String commend = in.next();
                    int rank = in.nextInt();


                    Task newtask = new Task();

                    newtask.setName(name);
                    newtask.setRank(rank);
                    newtask.setComment(commend);
                    newtask.setCreateTime(time);

                    list.addTask(newtask);

                    break;

                case '2':
                    System.out.println("Please Enter Task's Number, FinishTime with line break");//每个之后都要输入换行符号
                    int num = in.nextInt();
                    String finishTime = in.next();

                    list.signTask(num, finishTime);

                    break;

                case '3':

                    list.showUnfinishedTasks();

                    break;

                case '4':

                    list.showFinishedTasks();

                    break;

                case '5':

                    System.out.println("Please Enter the Name Keyword of the Task you want to search");//每个之后都要输入换行符号

                    name = in.next(); //上面定义过了

                    list.searchTaskName(name);

                    break;

                case '6':
                    System.out.println("Please Enter the Comment Keyword of the Task you want to search");//每个之后都要输入换行符号

                    String comment = in.next();

                    list.searchTaskComment(comment);

                    break;

                case '7':
                    System.out.println("Please Enter the Create Time(YYYY-MM-DD) of the Task you want to search");//每个之后都要输入换行符号

                    time = in.next();

                    list.searchTaskCreateTime(time);

                    break;

                case '8':
                    System.out.println("Please Enter the Finish Time(YYYY-MM-DD) of the Task you want to search");//每个之后都要输入换行符号

                    time = in.next();

                    list.searchTaskFinishTime(time);

                    break;

                case '9':
                    System.out.println("Please Enter the Rank of the Task you want to search");//每个之后都要输入换行符号

                    rank = in.nextInt();

                    list.searchTaskRank(rank);

                    break;

                case '#':

                    indexBook();

                    break;

            }
        }
    }

}
