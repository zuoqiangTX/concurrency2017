package cn.com.zuoqiang.test.chapter4;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class ResultFutureTask extends FutureTask<String> {
    private String name;

    public ResultFutureTask(Callable<String> callable) {
        super(callable);
        this.name = ((ExecutableTask) callable).getName();
    }

    @Override
    protected void done() {   //执行任务完成以后执行
        if (isCancelled()) {
            System.out.printf("%s : Has been canceled\n", name);
        } else {
            System.out.printf("%s : Has finished\n", name);
        }
    }
}
