package cn.com.zuoqiang.test.chapter7;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class SleepTwoSecondsTaskMain {
    public static void main(String[] args) {
        MyExecutor executor = new MyExecutor(2, 4, 100, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());
        List<Future<String>> results = new ArrayList<Future<String>>();
        for (int i = 0; i < 10; i++) {
            SleepTwoSecondsTask task = new SleepTwoSecondsTask();
            Future<String> result = executor.submit(task);
            results.add(result);
        }
        for (int i = 0; i < 5; i++) {
            try {
                String result = results.get(i).get();
                System.out.printf("Main result for Task %d : %s\n", i, result);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        executor.shutdown();
        for (int i = 0; i < 5; i++) {
            try {
                String result = results.get(i).get();
                System.out.printf("Main result for Task %d : %s\n", i, result);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        try {
            executor.awaitTermination(1,TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("程序结束！！！！！！！");

    }
}
