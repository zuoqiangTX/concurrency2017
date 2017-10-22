package cn.com.zuoqiang.test.chapter1;

public class MyThreadFactoryMain {
    public static void main(String[] args) {
        MyThreadFactory threadFactory = new MyThreadFactory("MyThreadFactory");
        ThreadFactoryTask task = new ThreadFactoryTask();
        Thread thread;
        System.out.printf("Strating the Threads\n !");
        for (int i = 0; i < 10; i++) {
            thread = threadFactory.newThread(task);
            thread.start();
        }
        System.out.printf("Factory status :\n");
        System.out.printf("%s\n", threadFactory.getStats());
    }
}
