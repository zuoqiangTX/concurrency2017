package cn.com.zuoqiang.test.chapter6;

import java.util.concurrent.ThreadLocalRandom;

public class RandomMain {
    public static void main(String[] args) {
        Thread[] threads = new Thread[3];
        for (int i = 0; i < 3; i++) {
            ThreadLocalRandom task = new ThreadLocalRandom();
            threads[i] = new Thread(task);
            threads[i].start();
        }
    }
}
