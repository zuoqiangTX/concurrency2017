package cn.com.zuoqiang.test.chapter6;

import java.util.Date;
import java.util.concurrent.DelayQueue;

public class DelayedTask implements Runnable {
    private int id;
    private DelayQueue<DelayEvent> queue;

    public DelayedTask(int id, DelayQueue<DelayEvent> queue) {
        this.id = id;
        this.queue = queue;
    }

    public void run() {
        Date now = new Date();
        Date delay = new Date();
        delay.setTime(now.getTime() + (id * 1000));
        System.out.printf("Thread %s : %s\n", id, delay);
        for (int i = 0; i < 100; i++) {
            DelayEvent event = new DelayEvent(delay);
            queue.add(event);
        }
    }
}
