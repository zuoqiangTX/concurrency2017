package cn.com.zuoqiang.test.chapter4;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

public class RejectedTaskController implements RejectedExecutionHandler {
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.printf("Task 被拒绝", r.toString());
        System.out.printf("RejectedController %s\n", executor.toString());
        System.out.printf("Termating : %s\n", executor.isTerminating());
        System.out.printf("Termated : %s\n", executor.isTerminated());
    }
}
