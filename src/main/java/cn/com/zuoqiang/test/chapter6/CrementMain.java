package cn.com.zuoqiang.test.chapter6;

import java.util.concurrent.atomic.AtomicIntegerArray;

public class CrementMain {
    public static void main(String[] args) {
        final int THREADS = 100;
        AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(1000);
        Incrementer incrementer = new Incrementer(atomicIntegerArray);
        Decrementer decrementer = new Decrementer(atomicIntegerArray);
        Thread[] threadsIn = new Thread[THREADS];
        Thread[] threadsDe = new Thread[THREADS];
        for (int i = 0; i < THREADS; i++) {
            threadsIn[i] = new Thread(incrementer);
            threadsDe[i] = new Thread(decrementer);
            threadsIn[i].start();
            threadsDe[i].start();
        }
        for (int i = 0; i < THREADS; i++) {
            try {
                threadsDe[i].join();
                threadsIn[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int i = 0; i < atomicIntegerArray.length(); i++) {
            System.out.println("数组[ " + i + " ]" + atomicIntegerArray.get(i));
        }
        System.out.println("MAIN ENDED");
    }
}
