package cn.com.zuoqiang.test.chapter6;

import java.util.concurrent.PriorityBlockingQueue;

public class Task implements Runnable {
    private PriorityBlockingQueue<Event> queue;
    private int id;  //Task的编号

    public Task(PriorityBlockingQueue<Event> queue, int id) {
        this.queue = queue;
        this.id = id;
    }

    public void run() {
        for (int i = 0; i < 1000; i++) {
            Event event = new Event(id,i);
            queue.add(event);
        }
    }
}
