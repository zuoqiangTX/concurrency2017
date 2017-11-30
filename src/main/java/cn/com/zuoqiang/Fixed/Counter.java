package cn.com.zuoqiang.Fixed;

import java.util.concurrent.CountDownLatch;

public class Counter {
    private static volatile int num = 0;
    static CountDownLatch downLatch = new CountDownLatch(30);

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 30; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 10000; j++) {
                        num++;   //这一步不是原子性的操作要分三步：取值 加一 赋值
                    }
                    downLatch.countDown();
                }
            }).start();
        }
        downLatch.await();  //等待所有的线程计算完
        System.out.println(num);
    }

}
