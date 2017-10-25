package cn.com.zuoqiang.test.chapter4;

import java.util.concurrent.*;

public class CancelMain {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        CancelTask task = new CancelTask();
        System.out.println("Main : Executing the Tasks\n");
        Future<String> result = executor.submit(task);
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Main : Canceling the task\n");
        result.cancel(true);
        System.out.printf("Main : Cancelled %s\n", result.isCancelled());
        System.out.printf("Main : Done %s\n", result.isDone());
        executor.shutdown();
        System.out.println("Main ended'");
/*        try {
            String str = result.get();  //将要抛出异常，因为已经取消了
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }*/
    }
}
