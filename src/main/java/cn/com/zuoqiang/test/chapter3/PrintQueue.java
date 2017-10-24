package cn.com.zuoqiang.test.chapter3;

import java.util.concurrent.Semaphore;

public class PrintQueue {
    private Semaphore semaphore;

    public PrintQueue() {
        semaphore = new Semaphore(1);
    }

    public void printJob(Object document) {
        try {
            semaphore.acquire();
            long duration = (long) (Math.random() * 10);
            System.out.println(Thread.currentThread().getName() + "打印Job花费了" + duration + "seconds.");
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }

    }
}
