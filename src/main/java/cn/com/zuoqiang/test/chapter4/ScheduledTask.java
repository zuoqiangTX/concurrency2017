package cn.com.zuoqiang.test.chapter4;

import java.util.Date;
import java.util.concurrent.Callable;

public class ScheduledTask implements Callable<String> {
    private String name;

    public ScheduledTask(String name) {
        this.name = name;
    }

    public String call() throws Exception {
        System.out.printf("%s : Starting at %s\n", name, new Date());
        return "Hello World";
    }
}
