package cn.com.zuoqiang.test.chapter2;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Buffer {
    private LinkedList<String> buffer;  //存放共享数据
    private int maxSize;  //buffer长度
    private ReentrantLock lock;   //对修改buffer的代码块进行控制
    private Condition lines;  //是否有多余的数据
    private Condition space;  //是否有空位

    public void setPendingLines(boolean pendingLines) {
        this.pendingLines = pendingLines;
    }

    private boolean pendingLines;  //表示缓冲区是否还有数据

    public Buffer(int maxSize) {
        this.buffer = new LinkedList<String>();
        this.maxSize = maxSize;
        this.lock = new ReentrantLock();
        this.lines = lock.newCondition();
        this.space = lock.newCondition();
        this.pendingLines = true;
    }

    /*它先检查缓存区，如果满了，线程挂起，等待space的await等待空位出现，当其他线程调用space的signall时候，这个线程将被唤醒，然后
    *它将增加东西，然后调用lines的singAll方法，唤醒所有等待缓存区中有数据的线程。
    */
    public void insert(String line) {
        lock.lock();
        try {
            while (buffer.size() == maxSize) {
                space.await();   //等待space条件出现
            }
            buffer.offer(line);
            System.out.printf("%s 增加了lines %d\n", Thread.currentThread().getName(), buffer.size());
            lines.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    /*检查缓存区是否有数据行，如果是空的，调用条件line.await等待有数据出现，当其他线程通知他有数据的时候（signal），这个线程将被唤醒
    *在有数据的时候，获取第一行，调用space的唤醒条件，返回这个字符串
    * */
    public String get() {
        String line = null;
        lock.lock();
        try {
            while ((buffer.size() == 0) && (hasPendingLines())) {
                lines.await();
            }
            line = buffer.poll();
            System.out.printf("%s 读到了lines %d\n", Thread.currentThread().getName(), buffer.size());
            space.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return line;
    }

    public boolean hasPendingLines() {
        return pendingLines || buffer.size() > 0;
    }
}
