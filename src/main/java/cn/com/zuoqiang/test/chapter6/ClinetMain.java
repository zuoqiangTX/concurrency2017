package cn.com.zuoqiang.test.chapter6;

import java.util.Date;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class ClinetMain {
    public static void main(String[] args) throws InterruptedException {
        LinkedBlockingQueue<String> list = new LinkedBlockingQueue<String>(3);
        Client client = new Client(list);
        Thread thread = new Thread(client);
        thread.start();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                String request = list.take();
                System.out.printf("Main: Request %s at %s\n", request, new Date());
            }
            TimeUnit.MILLISECONDS.sleep(300);
        }
        System.out.println("Main : end");
    }
}
