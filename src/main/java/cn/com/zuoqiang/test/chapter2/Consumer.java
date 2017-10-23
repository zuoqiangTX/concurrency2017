package cn.com.zuoqiang.test.chapter2;

public class Consumer implements Runnable {
    private EventStorage eventStorage;

    public Consumer(EventStorage eventStorage) {
        this.eventStorage = eventStorage;
    }

    public void run() {
        for (int i = 0; i < 100; i++) {
            eventStorage.get();
        }
    }
}
