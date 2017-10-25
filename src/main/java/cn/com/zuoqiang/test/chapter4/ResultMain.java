package cn.com.zuoqiang.test.chapter4;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ResultMain {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        List<ResultTask> taskLists = new ArrayList<ResultTask>();
        for (int i = 0; i < 3; i++) {
            ResultTask task = new ResultTask("Task" + i);
            taskLists.add(task);
        }
        List<Future<Result>> resultLists = null;
        try {
            resultLists = executorService.invokeAll(taskLists);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
        System.out.println("Main : Print the results !");
        for (int i = 0; i < resultLists.size(); i++) {
            Future<Result> future = resultLists.get(i);
            try {
                Result result = future.get();
                System.out.println(result.getName() + ":" + result.getValue());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}
