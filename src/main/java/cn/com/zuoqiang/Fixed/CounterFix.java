package cn.com.zuoqiang.Fixed;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class CounterFix {
    public static AtomicInteger num = new AtomicInteger(0);
    static CountDownLatch downLatch = new CountDownLatch(30);

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 30; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 10000; j++) {
                        num.incrementAndGet();   //这一步是原子性
                    }
                    downLatch.countDown();
                }
            }).start();
        }
        downLatch.await();  //等待所有的线程计算完
        System.out.println(num);
    }

}
