package cn.com.zuoqiang.test.chapter3;

public class MoreJob implements Runnable {
    private MorePrintQueue printQueue;

    public MoreJob(MorePrintQueue printQueue) {
        this.printQueue = printQueue;
    }

    public void run() {
        System.out.printf("%s : going to print a job.\n", Thread.currentThread().getName());
        printQueue.printJob(new Object());
        System.out.printf("%s : has been printed a job.\n", Thread.currentThread().getName());
    }
}
