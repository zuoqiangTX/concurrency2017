package cn.com.zuoqiang.test.chapter2;

import java.util.concurrent.TimeUnit;

public class JobFairMain {
    public static void main(String[] args) {
        PrintFairQueue printFairQueue = new PrintFairQueue();
        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(new FairJob(printFairQueue), "Thread" + i);
        }
        for (int i = 0; i < 10; i++) {
            threads[i].start();
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
