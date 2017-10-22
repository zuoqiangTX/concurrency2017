package cn.com.zuoqiang.test.chapter1;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class UnSafeTask implements Runnable {
    private Date startDate;

    public void run() {
        startDate = new Date();
        System.out.printf("Starting Thread : %s : %s\n", Thread.currentThread().getId(), startDate);
        try {
            TimeUnit.SECONDS.sleep((int) Math.rint(Math.random() * 10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Finshed Thread : %s : %s\n", Thread.currentThread().getId(), startDate);

    }
}
