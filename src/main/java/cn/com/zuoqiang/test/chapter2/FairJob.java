package cn.com.zuoqiang.test.chapter2;

public class FairJob implements Runnable {
    private PrintFairQueue printQueue;

    public FairJob(PrintFairQueue printQueue) {
        this.printQueue = printQueue;
    }

    public void run() {
        System.out.printf(" %s 打印一个文档\n", Thread.currentThread().getName());
        printQueue.printJob(new Object());
        System.out.printf("%s 已经打印好了文档\n", Thread.currentThread().getName());
    }
}
