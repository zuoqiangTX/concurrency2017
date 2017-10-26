package cn.com.zuoqiang.test.chapter6;

import java.util.concurrent.PriorityBlockingQueue;

public class EventMain {
    public static void main(String[] args) {
        PriorityBlockingQueue<Event> queue = new PriorityBlockingQueue<Event>();
        Thread[] threads = new Thread[5];
        for (int i = 0; i < threads.length; i++) {
            Task task = new Task(queue, i);
            threads[i] = new Thread(task);
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
        System.out.println("Main : 队列大小：" + queue.size());
        for (int i = 0; i < threads.length * 1000; i++) {
            Event event = queue.poll();
            System.out.println(event.getThread() + "线程 ：优先级" + event.getPriority());
        }
        System.out.println("Main end: 队列大小：" + queue.size());
        System.out.println("Main 结束！");
    }
}
