package cn.com.zuoqiang.test.chapter2;

public class EventStrogeMain {
    public static void main(String[] args) {
        EventStorage storage = new EventStorage();
        Producer producer = new Producer(storage);
        Thread thread1 = new Thread(producer);
        Consumer consumer = new Consumer(storage);
        Thread thread2 = new Thread(consumer);
        thread1.start();
        thread2.start();
    }
}
