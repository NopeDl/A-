/**
方法：
1.展示当前的任务列表
2.支持添加任务
3.支持(按照名字）查找指定任务
4.支持标记完成任务

 tdl类
 状态：总任务(数)，完成任务(数)，未完成任务(数)，所有的任务
date: 2022-12-09
user: BaRa
 */
public class TaskList {

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getTaskNum() {
        return taskNum;
    }

    public void setTaskNum(int taskNum) {
        this.taskNum = taskNum;
    }

    public int getFinishNum() {
        return finishNum;
    }

    public void setFinishNum(int finishNum) {
        this.finishNum = finishNum;
    }

    private int capacity = 0;//同时也是总任务数

    private int N = 20;

    private Task[] tasks = new Task[N]; //未进阶

    private int taskNum;

    private int finishNum;

    public void showAllTasks() {
        System.out.printf("There have been %d tasks taken down in the Task-list.\n", getCapacity());
        //System.out.printf(", but still have %d tasks unfinished.\n", getFinishNum(), getTaskNum());
        System.out.print("num\tlist name\tstate\tcreate time\tfinish time\trank\tcomment\n");
        for (int i = 0; i < capacity; i++) {
            System.out.printf("%d\t%s\t%b\t%s\t%s\t%d\t%s\n",
                    i, tasks[i].getName(), tasks[i].isState(), tasks[i].getCreateTime(),
                    tasks[i].getFinishTime(), tasks[i].getRank(), tasks[i].getComment());
        }
    }

    public void showUnfinishedTasks() {
        System.out.printf("You have done %d tasks.\n", getTaskNum());
        System.out.print("num\tlist name\tstate\tcreate time\tfinish time\trank\tcomment\n");
        for (int i = 0; i < capacity; i++) {
            if (tasks[i].isState()) continue;
            System.out.printf("%d\t%s\t%b\t%s\t%s\t%d\t%s\n",
                    i, tasks[i].getName(), tasks[i].isState(), tasks[i].getCreateTime(),
                    tasks[i].getFinishTime(), tasks[i].getRank(), tasks[i].getComment());
        }
    }

    public void showFinishedTasks() {
        System.out.printf("You still have %d tasks unfinished.\n", getFinishNum());
        System.out.print("num\tlist name\tstate\tcreate time\tfinish time\trank\tcomment\n");
        for (int i = 0; i < capacity; i++) {
            if (!tasks[i].isState()) continue;
            System.out.printf("%d\t%s\t%b\t%s\t%s\t%d\t%s\n",
                    i, tasks[i].getName(), tasks[i].isState(), tasks[i].getCreateTime(),
                    tasks[i].getFinishTime(), tasks[i].getRank(), tasks[i].getComment());
        }
    }

    public void addTask(Task newTask) {
        int num = getCapacity();
        setCapacity(num+1);
        tasks[num] = newTask;
        setTaskNum(getTaskNum() + 1);
    }

    public void signTask(int num, String time) {
        tasks[num].setState(!tasks[num].isState());
        tasks[num].setFinishTime(time);
        setFinishNum(getFinishNum() + 1);
    }

    //不区分大小写搜索，字串搜索
    public void searchTaskName(String name){
        int t = getCapacity();
        for (int i = 0; i < t; i++) {
            if (tasks[i].getName().contains(name)) {
                System.out.printf("%d\t%s\t%b\t%s\t%s\t%d\t%s\n",
                        i, tasks[i].getName(), tasks[i].isState(), tasks[i].getCreateTime(),
                        tasks[i].getFinishTime(), tasks[i].getRank(), tasks[i].getComment());
            }
        }
    }

    //按照重要程度搜索
    public void searchTaskRank(int rank){
        int t = getCapacity();
        for (int i = 0; i < t; i++) {
            if (tasks[i].getRank()== rank) {
                System.out.printf("%d\t%s\t%b\t%s\t%s\t%d\t%s\n",
                        i, tasks[i].getName(), tasks[i].isState(), tasks[i].getCreateTime(),
                        tasks[i].getFinishTime(), tasks[i].getRank(), tasks[i].getComment());
            }
        }
    }

    //按照时间格式搜索
    public void searchTaskCreateTime(String time){
        int t = getCapacity();
        for (int i = 0; i < t; i++) {
            if (tasks[i].getCreateTime().equals(time)) {
                System.out.printf("%d\t%s\t%b\t%s\t%s\t%d\t%s\n",
                        i, tasks[i].getName(), tasks[i].isState(), tasks[i].getCreateTime(),
                        tasks[i].getFinishTime(), tasks[i].getRank(), tasks[i].getComment());
            }
        }
    }

    public void searchTaskFinishTime(String time){
        int t = getCapacity();
        for (int i = 0; i < t; i++) {
            if (tasks[i].getFinishTime().equals(time)) {
                System.out.printf("%d\t%s\t%b\t%s\t%s\t%d\t%s\n",
                        i, tasks[i].getName(), tasks[i].isState(), tasks[i].getCreateTime(),
                        tasks[i].getFinishTime(), tasks[i].getRank(), tasks[i].getComment());
            }
        }
    }

    //备注关键词搜索
    public void searchTaskComment(String comment){
        int t = getCapacity();
        for (int i = 0; i < t; i++) {
            if (tasks[i].getComment().contains(comment)) {
                System.out.printf("%d\t%s\t%b\t%s\t%s\t%d\t%s\n",
                        i, tasks[i].getName(), tasks[i].isState(), tasks[i].getCreateTime(),
                        tasks[i].getFinishTime(), tasks[i].getRank(), tasks[i].getComment());
            }
        }
    }

}