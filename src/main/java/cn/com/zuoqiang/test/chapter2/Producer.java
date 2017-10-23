package cn.com.zuoqiang.test.chapter2;

public class Producer implements Runnable {
    private EventStorage eventStorage;

    public Producer(EventStorage eventStorage) {
        this.eventStorage = eventStorage;
    }

    public void run() {
        for (int i = 0; i < 100; i++) {
            eventStorage.set();
        }
    }
}
