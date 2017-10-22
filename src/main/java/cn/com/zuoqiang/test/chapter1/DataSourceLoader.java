package cn.com.zuoqiang.test.chapter1;

import java.sql.Time;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DataSourceLoader implements Runnable {
    public void run() {
        System.out.printf("Begin data Source loading : %s\n", new Date());
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Begin data Source finshed : %s\n", new Date());

    }
}
