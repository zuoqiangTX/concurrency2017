package cn.com.zuoqiang.BlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueTest {
    public static final int QUEUE_SIZE = 1024;
    public static void main(String[] args) {
        BlockingQueue blockingQueue = new ArrayBlockingQueue(QUEUE_SIZE);
        //启动生产者
        Producer producer = new Producer(blockingQueue);
        //启动消费者
        Consumer consumer = new Consumer(blockingQueue);
        new Thread(producer).start();
        new Thread(consumer).start();
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
