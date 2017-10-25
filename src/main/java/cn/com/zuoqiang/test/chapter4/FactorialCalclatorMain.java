package cn.com.zuoqiang.test.chapter4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class FactorialCalclatorMain {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
        List<Future<Integer>> resultList = new ArrayList<Future<Integer>>();
        Random random = new Random();
        //生成十个随机数字
        for (int i = 0; i < 10; i++) {
            Integer number = random.nextInt(10);
            FactorialCalculator factorialCalculator = new FactorialCalculator(number);
            Future<Integer> result = executor.submit(factorialCalculator);
            resultList.add(result);
        }
        do {
            System.out.printf("Main : Completed Tasks : %d\n", executor.getCompletedTaskCount());
            for (int i = 0; i < resultList.size(); i++) {
                Future<Integer> result = resultList.get(i);
                System.out.printf("Main : Tasks %d : %s\n", i, result.isDone());
            }
            try {
                TimeUnit.MILLISECONDS.sleep(50); //sleep 50ms
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        } while (executor.getCompletedTaskCount() < resultList.size());
        System.out.println("Main result\n");
        for (int i = 0; i < resultList.size(); i++) {
            Future<Integer> result = resultList.get(i);
            Integer num = null;
            try {
                num = result.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            System.out.println("Task" + i + "执行的结果为" + num);
        }
        executor.shutdown();
    }
}
