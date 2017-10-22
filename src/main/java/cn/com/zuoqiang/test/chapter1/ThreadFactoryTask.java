package cn.com.zuoqiang.test.chapter1;

import java.util.concurrent.TimeUnit;

public class ThreadFactoryTask implements Runnable {
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
