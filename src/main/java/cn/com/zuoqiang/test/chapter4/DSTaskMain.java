package cn.com.zuoqiang.test.chapter4;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class DSTaskMain {
    public static void main(String[] args) {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        System.out.println("Main Started :" + new Date());
        DSTask task = new DSTask("Task");
        ScheduledFuture<?> result = executor.scheduleAtFixedRate(task, 1, 2, TimeUnit.SECONDS);
        for (int i = 0; i < 10; i++) {
            System.out.printf("Main : delay ： %d\n", result.getDelay(TimeUnit.MILLISECONDS)); //获取任务下一次将要执行的毫秒数
            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        executor.shutdown();
        System.out.printf("Main: Finshed at %s\n", new Date());
    }
}
