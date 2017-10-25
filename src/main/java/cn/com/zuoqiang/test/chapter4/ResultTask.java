package cn.com.zuoqiang.test.chapter4;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class ResultTask implements Callable<Result> {
    private String name;

    public ResultTask(String name) {
        this.name = name;
    }

    public Result call() throws Exception {
        System.out.printf("%s : Starting\n", this.name);
        TimeUnit.SECONDS.sleep((long) (Math.random() * 10));
        int value = 0;
        for (int i = 0; i < 5; i++) {
            value += Math.random() * 100;
        }
        Result result = new Result();
        result.setName(this.name);
        result.setValue(value);
        System.out.println(this.name + "Ends");
        return result;
    }
}
