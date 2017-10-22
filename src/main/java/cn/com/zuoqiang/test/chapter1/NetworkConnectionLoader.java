package cn.com.zuoqiang.test.chapter1;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class NetworkConnectionLoader implements Runnable {

    public void run() {
        System.out.printf("Begin NetworkConnection loading : %s\n", new Date());
        try {
            TimeUnit.SECONDS.sleep(6);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Begin NetworkConnection finshed : %s\n", new Date());


    }
}
