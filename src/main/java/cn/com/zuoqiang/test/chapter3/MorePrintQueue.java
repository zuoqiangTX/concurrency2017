package cn.com.zuoqiang.test.chapter3;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MorePrintQueue {
    private boolean[] freePrinters;  //存放打印机的状态
    private Lock lockPrinters;    //保护对数组的访问
    private Semaphore semaphore;

    public MorePrintQueue() {
        this.semaphore = new Semaphore(3);
        this.lockPrinters = new ReentrantLock();
        freePrinters = new boolean[3];
        for (int i = 0; i < freePrinters.length; i++) {
            freePrinters[i] = true;
        }
    }

    public void printJob(Object document) {
        try {
            semaphore.acquire();
            int assignPrinter = getPrinter();
            long duration = (long) (Math.random() * 10);
            System.out.println(Thread.currentThread().getName() + "打印Job花费了" + duration + "seconds.");
            Thread.sleep(duration);
            freePrinters[assignPrinter] = true;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }

    }

    //获得分配的打印机编号
    private int getPrinter() {
        int ret = -1;
        //获得锁，只允许一个线程对数组进行操作
        try {
            lockPrinters.lock();
            for (int i = 0; i < freePrinters.length; i++) {
                if (freePrinters[i]) {
                    ret = i;
                    freePrinters[i] = false;
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lockPrinters.unlock();
        }
        return ret;
    }
}
