package cn.com.zuoqiang.test.chapter5;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveAction;

public class MyRecursiveAction extends RecursiveAction {
    private long workLoad = 0;  //工作阈值

    public MyRecursiveAction(long workLoad) {
        this.workLoad = workLoad;
    }

    protected void compute() {
        if (workLoad > 16) {
            System.out.println("分割子任务: " + workLoad);
            List<MyRecursiveAction> subtasks = new ArrayList<MyRecursiveAction>();
            subtasks.addAll(createSubTasks());
            for (RecursiveAction subtask : subtasks) {
                subtask.fork();
            }
        } else {
            System.out.println("自己做任务不分割" + workLoad);
        }

    }

    private List<MyRecursiveAction> createSubTasks() {
        List<MyRecursiveAction> subtasks = new ArrayList<MyRecursiveAction>();
        MyRecursiveAction action1 = new MyRecursiveAction(this.workLoad / 2);
        MyRecursiveAction action2 = new MyRecursiveAction(this.workLoad / 2);
        subtasks.add(action1);
        subtasks.add(action2);
        return subtasks;
    }
}
