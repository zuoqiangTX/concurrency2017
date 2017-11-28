package cn.com.zuoqiang.test.chapter5;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class MyRecursiveTask extends RecursiveTask<Long> {
    private long workLoad = 0;

    public MyRecursiveTask(long workLoad) {
        this.workLoad = workLoad;
    }

    @Override
    protected Long compute() {
        if (workLoad > 16) {
            System.out.println("分割子任务: " + workLoad);
            List<MyRecursiveTask> subtasks = new ArrayList<MyRecursiveTask>();
            subtasks.addAll(createSubTasks());
            for (RecursiveTask subtask : subtasks) {
                subtask.fork();
            }
            long result = 0;
            for (MyRecursiveTask task : subtasks) {
                result += task.join();  //获取每个子任务的结果
            }
            return result;

        } else {
            System.out.println("自己做任务不分割" + workLoad);
            return workLoad * 3;
        }
    }

    private List<MyRecursiveTask> createSubTasks() {
        List<MyRecursiveTask> subtasks = new ArrayList<MyRecursiveTask>();
        MyRecursiveTask action1 = new MyRecursiveTask(this.workLoad / 2);
        MyRecursiveTask action2 = new MyRecursiveTask(this.workLoad / 2);
        subtasks.add(action1);
        subtasks.add(action2);
        return subtasks;
    }
}
