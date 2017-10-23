package cn.com.zuoqiang.test.chapter2;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class EventStorage {
    private int maxSize;
    private List<Date> storge;

    public EventStorage() {
        this.maxSize = 10;
        storge = new LinkedList<Date>();
    }

    //首先检查是否已满，符合条件的话挂起线程并等待空余空间的出现。
    public synchronized void set() {
        while (storge.size() == maxSize) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        storge.add(new Date());
        System.out.println("Set :" + storge.size());
        notifyAll();
    }

    //首先检查是否为空，为空就挂起，否则就继续往下执行
    public synchronized void get() {
        while (storge.size() == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Get :" + storge.size() + ((LinkedList<?>)storge).poll());
        notifyAll();
    }
}
