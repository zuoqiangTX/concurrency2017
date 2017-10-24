package cn.com.zuoqiang.test.chapter3;

public class MoreJobMain {
    public static void main(String[] args) {
        MorePrintQueue morePrintQueue = new MorePrintQueue();
        //10个线程共享打印队列
        Thread[] threads = new Thread[10];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new MoreJob(morePrintQueue),"Thread" + i);
        }
        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }
    }
}
