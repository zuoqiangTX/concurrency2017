package cn.com.zuoqiang.test.chapter1;

import java.util.Random;

public class GroupTask implements Runnable {
    public void run() {
        //触发一个unchecked异常
        int result;
        Random random = new Random(Thread.currentThread().getId());
        while (true) {
            result = 1000 / (int) ((random.nextDouble() * 1000));
            System.out.printf("%s : %d\n", Thread.currentThread().getId(), result);
            if (Thread.currentThread().isInterrupted()) {
                System.out.printf("%d : Interrupted\n", Thread.currentThread().getId());
                return;
            }
        }
    }
}
