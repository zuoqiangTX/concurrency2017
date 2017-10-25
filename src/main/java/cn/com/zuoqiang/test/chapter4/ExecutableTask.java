package cn.com.zuoqiang.test.chapter4;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class ExecutableTask implements Callable<String> {
    private String name;

    public ExecutableTask(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String call() throws Exception {
        long duration = (long) (Math.random() * 10);
        System.out.printf("%s: Waiting %d seconds for results\n", name, duration);
        try {
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Hello World, I'm " + name;
    }
}
