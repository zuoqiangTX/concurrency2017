package cn.com.zuoqiang.test.chapter1;

public class GroupMain {
    public static void main(String[] args) {
        MyThreadGroup threadGroup = new MyThreadGroup("MyThreadGroup");
        GroupTask task = new GroupTask();
        for (int i = 0; i < 2; i++) {
            Thread thread = new Thread(threadGroup, task);
            thread.start();
        }
    }
}
