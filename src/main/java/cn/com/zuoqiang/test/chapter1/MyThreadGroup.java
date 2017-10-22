package cn.com.zuoqiang.test.chapter1;

public class MyThreadGroup extends ThreadGroup {
    public MyThreadGroup(String name) {
        super(name);
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.printf("The Thread %s has throw an Exception \n", t.getId());
        e.printStackTrace(System.out); //打印异常信息
        System.out.printf("Terminating the rest of the Threads\n");
        interrupt();  //中断线程组的其他线程
    }
}
