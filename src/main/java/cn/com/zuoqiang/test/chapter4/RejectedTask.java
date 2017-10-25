package cn.com.zuoqiang.test.chapter4;

import java.util.concurrent.TimeUnit;

public class RejectedTask implements Runnable {

    private String name;

    public RejectedTask(String name) {
        this.name = name;
    }

    public void run() {
        System.out.println("Task" + name + "Starting");
        long duration = (long) (Math.random() * 100);
        try {
            System.out.println("Task" + name + "打印报告花了" + duration + "s");
            TimeUnit.MILLISECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Task %s ending\n", name);
    }

    @Override
    public String toString() {
        return name;
    }
}
