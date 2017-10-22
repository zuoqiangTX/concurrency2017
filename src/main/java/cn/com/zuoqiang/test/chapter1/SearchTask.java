package cn.com.zuoqiang.test.chapter1;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class SearchTask implements Runnable {
    private Result result;

    public SearchTask(Result result) {
        this.result = result;
    }

    public void run() {    //run方法不支持throws语句，必须捕获并处理异常
        String name = Thread.currentThread().getName();
        System.out.printf("Thread %s : Start\n", name);
        try {
            doTask();
            result.setName(name);
        } catch (InterruptedException e) {
            System.out.printf("Thread %s\n :Interupted\n", name);
            return;
        }
        System.out.printf("Thread %s : End\n", name);

    }

    private void doTask() throws InterruptedException {
        Random random = new Random((new Date()).getTime());
        int value = (int) (random.nextDouble() * 1000);
        System.out.printf("Thread %s : %d\n", Thread.currentThread().getName(), value);
        TimeUnit.SECONDS.sleep(value);
    }
}
