package cn.com.zuoqiang.test.chapter7;

import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class SleepTwoSecondsTask implements Callable {
    public String call() throws Exception {
        TimeUnit.SECONDS.sleep(2);
        return new Date().toString();
    }
}