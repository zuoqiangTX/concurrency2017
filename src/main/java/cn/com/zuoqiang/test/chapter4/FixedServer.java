package cn.com.zuoqiang.test.chapter4;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class FixedServer {
    private ThreadPoolExecutor executor;

    public FixedServer() {
        this.executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);
    }

    public void executeTask(Task task) {
        System.out.printf("Server : A new task has arrived\n");
        executor.execute(task);
        System.out.printf("Server : Pool Size : %d\n", executor.getPoolSize()); //线程池大小
        System.out.printf("Server : Tasks Count: %d\n", executor.getTaskCount()); //已经收到的任务
        System.out.printf("Server : Active Count : %d\n", executor.getActiveCount());  //正在执行器中执行任务的数量
        System.out.printf("Server : Completed Tasks : %d\n", executor.getCompletedTaskCount());
    }

    public void endServer() {
        executor.shutdown();
    }
}
