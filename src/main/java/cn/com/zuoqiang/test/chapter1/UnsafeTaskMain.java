package cn.com.zuoqiang.test.chapter1;

import java.util.concurrent.TimeUnit;

public class UnsafeTaskMain {
    public static void main(String[] args) {
        UnSafeTask task = new UnSafeTask();
        for (int i = 0; i < 3; i++) {
            Thread thread = new Thread(task);
            thread.start();
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
