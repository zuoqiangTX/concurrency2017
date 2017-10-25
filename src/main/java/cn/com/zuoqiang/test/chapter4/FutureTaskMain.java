package cn.com.zuoqiang.test.chapter4;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class FutureTaskMain {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        ResultFutureTask[] resultFutureTasks = new ResultFutureTask[5];
        for (int i = 0; i < 5; i++) {
            ExecutableTask task = new ExecutableTask("Task" + i);
            resultFutureTasks[i] = new ResultFutureTask(task);
            executor.submit(resultFutureTasks[i]);
        }
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < resultFutureTasks.length; i++) {
            resultFutureTasks[i].cancel(true);
        }
        for (int i = 0; i < resultFutureTasks.length; i++) {
            if (resultFutureTasks[i].isCancelled()) {
                try {
                    System.out.printf("%s\n", resultFutureTasks[i].get());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
        }
        executor.shutdown();
    }
}
