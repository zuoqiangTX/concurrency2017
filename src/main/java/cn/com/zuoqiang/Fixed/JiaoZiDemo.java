package cn.com.zuoqiang.Fixed;

import java.util.concurrent.TimeUnit;

public class JiaoZiDemo {
    private static Object lock = new Object(); //用做共享的监视器
    private static Integer platter = 0;
    private static Integer totalCount = 0;

    static class Cooker implements Runnable {
        @Override
        public void run() {
            while (totalCount < 100) {
                synchronized (lock) {
                    while (platter < 10) {
                        platter++;
                    }
                    lock.notify();   //通知数量达标了
                    System.out.println("饺子好啦，厨师休息会儿。");
                }
                try {
                    TimeUnit.MILLISECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("cooker工作完成！");
        }
    }

    static class Waiter implements Runnable {
        @Override
        public void run() {
            while (totalCount < 100) {
                synchronized (lock) {
                    while (platter < 10) {
                        System.out.println("饺子还没做好，等待通知！");
                        try {
                            lock.wait();   //程序将停在这里
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    platter -= 10;
                    totalCount += 10;
                    System.out.println("服务员把饺子端给客人！");
                }
            }
            System.out.println("waiter工作结束");

        }
    }

    public static void main(String[] args) {
        Thread cookerThread = new Thread(new Cooker(), "Cooker");
        Thread waiterThread = new Thread(new Waiter(), "waiter");
        cookerThread.start();
        waiterThread.start();
    }
}
