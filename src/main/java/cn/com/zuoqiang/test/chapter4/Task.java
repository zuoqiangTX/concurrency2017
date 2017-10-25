package cn.com.zuoqiang.test.chapter4;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Task implements Runnable{
    private Date initdate;
    private String name;

    public Task(String name) {
        this.initdate = new Date();
        this.name = name;
    }

    public void run() {
        System.out.printf("%s Task %s : Created on %s\n", Thread.currentThread().getName(), name, initdate);
        System.out.printf("%s Task %s : Started on %s\n", Thread.currentThread().getName(), name, new Date());
        try {
            long duration = (long) (Math.random() * 10);
            System.out.printf("%s Task %s : Doing a task during %d seconds.\n", Thread.currentThread().getName(), name, duration);
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("%s Task %s : Finished on %s\n", Thread.currentThread().getName(), name, new Date());

    }
}
