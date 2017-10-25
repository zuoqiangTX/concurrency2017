package cn.com.zuoqiang.test.chapter4;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class RejectedMain {
    public static void main(String[] args) {
        RejectedTaskController rejectedTaskController = new RejectedTaskController();
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        executor.setRejectedExecutionHandler(rejectedTaskController);
        System.out.println("主任务开始");
        for (int i = 0; i < 3; i++) {
            RejectedTask task = new RejectedTask("Task" + i);
            executor.submit(task);
        }
        System.out.printf("关闭执行器\n");
        executor.shutdown();
        System.out.println("发送另一个任务");
        RejectedTask task1 = new RejectedTask("rej-task");
        executor.submit(task1);
        System.out.println("主程序结束");
    }
}
