package cn.com.zuoqiang.test.chapter4;

import java.util.concurrent.Callable;

public class CancelTask implements Callable<String> {
    public String call() throws Exception {
        while (true) {
            System.out.println("Task test");
            Thread.sleep(100);
        }
    }
}
