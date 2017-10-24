package cn.com.zuoqiang.test.chapter3;

public class JobMain {
    public static void main(String[] args) {
        PrintQueue printQueue = new PrintQueue();
        //10个线程共享打印队列
        Thread[] threads = new Thread[10];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new Job(printQueue),"Thread" + i);
        }
        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }
    }
}
