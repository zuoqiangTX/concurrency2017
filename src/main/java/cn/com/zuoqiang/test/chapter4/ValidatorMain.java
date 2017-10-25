package cn.com.zuoqiang.test.chapter4;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ValidatorMain {
    public static void main(String[] args) {
        String name = "test";
        String password = "test";
        UserVaildator vaildator1 = new UserVaildator("佳慧");
        UserVaildator vaildator2 = new UserVaildator("小左");
        TaskValidator task1 = new TaskValidator(name, password, vaildator1);
        TaskValidator task2 = new TaskValidator(name, password, vaildator2);
        List<TaskValidator> tasks = new ArrayList<TaskValidator>();
        tasks.add(task1);
        tasks.add(task2);
        ExecutorService executor = Executors.newCachedThreadPool();
        String result;
        try {
            result = executor.invokeAny(tasks);
            System.out.printf("Main : Result : %s\n", result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        executor.shutdown();
        System.out.printf("Main END\n");

    }
}
