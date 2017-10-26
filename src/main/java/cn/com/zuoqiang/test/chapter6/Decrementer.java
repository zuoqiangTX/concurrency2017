package cn.com.zuoqiang.test.chapter6;

import java.util.concurrent.atomic.AtomicIntegerArray;

public class Decrementer implements Runnable {
    private AtomicIntegerArray vector;

    public Decrementer(AtomicIntegerArray vector) {
        this.vector = vector;
    }

    public void run() {
        for (int i = 0; i < vector.length(); i++) {
            vector.getAndDecrement(i);
        }
    }
}
