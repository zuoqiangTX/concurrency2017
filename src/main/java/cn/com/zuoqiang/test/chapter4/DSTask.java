package cn.com.zuoqiang.test.chapter4;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DSTask implements Runnable {
    private String name;

    public DSTask(String name) {
        this.name = name;
    }

    public void run() {
        System.out.println("任务执行时间为" + new Date());
        long duration = (long) (Math.random() * 100);
        try {
            TimeUnit.MILLISECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
