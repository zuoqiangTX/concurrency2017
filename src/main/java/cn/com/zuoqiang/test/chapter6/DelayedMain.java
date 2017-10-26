package cn.com.zuoqiang.test.chapter6;

import java.util.Date;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.TimeUnit;

public class DelayedMain {
    public static void main(String[] args) throws InterruptedException {
        DelayQueue<DelayEvent> queue = new DelayQueue<DelayEvent>();
        //5 threads
        Thread[] threads = new Thread[5];
        for (int i = 0; i < threads.length; i++) {
            DelayedTask delayedTask = new DelayedTask(i + 1, queue);
            threads[i] = new Thread(delayedTask);
        }
        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }
        for (int i = 0; i < threads.length; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        do {
            int counter = 0;
            DelayEvent event;
            do {
                event = queue.poll();
                if (event != null) {
                    counter++;
                }
            } while (event != null);
            System.out.printf("%s has %d events\n", new Date(), counter);
            TimeUnit.MILLISECONDS.sleep(500);   //如果返回null则休息500毫秒等待更多被激活
        } while (queue.size() > 0);
    }
}
