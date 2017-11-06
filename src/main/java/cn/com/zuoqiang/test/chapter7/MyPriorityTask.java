package cn.com.zuoqiang.test.chapter7;

import java.util.concurrent.TimeUnit;

public class MyPriorityTask implements Runnable, Comparable<MyPriorityTask> {
    private int priority;
    private String name;

    public int getPriority() {
        return priority;
    }

    public MyPriorityTask(int priority, String name) {

        this.priority = priority;
        this.name = name;
    }

    public int compareTo(MyPriorityTask o) {
        if (this.getPriority() < o.getPriority()) {
            return 1;
        }
        if (this.getPriority() > o.getPriority()) {
            return -1;
        }
        return 0;
    }

    public void run() {
        System.out.printf("MyPrority %s : %d\n", name, priority);
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
