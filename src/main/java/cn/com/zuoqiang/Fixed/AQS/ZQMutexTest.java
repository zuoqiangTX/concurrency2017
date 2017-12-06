package cn.com.zuoqiang.Fixed.AQS;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class ZQMutexTest {
    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(31);
    private static int a = 0;
    private static ZQMutex mutex = new ZQMutex();

    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        //未加锁前
        for (int i = 0; i < 30; i++) {
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 10000; j++) {
                        increment();
                    }
                    try {
                        cyclicBarrier.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
            });
            t.start();
        }
        cyclicBarrier.await();
        System.out.println("未加锁前的值为,a = " + a);
        cyclicBarrier.reset();  //重置cycliBarrier栅栏
        a = 0;
        //加锁后
        long start = System.currentTimeMillis();
        for (int i = 0; i < 30; i++) {
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    mutex.lock();
                    for (int j = 0; j < 10000; j++) {
                        increment();
                    }
                    mutex.unLock();
                    try {
                        cyclicBarrier.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
            });
            t.start();
        }
        cyclicBarrier.await();
        long end = System.currentTimeMillis();
        System.out.println("加锁后的值为,a = " + a + "时间为 " + (end - start));
    }

    public static void increment() {
        a++;
    }

}
