package cn.com.zuoqiang.test.chapter5;

import java.util.concurrent.ForkJoinPool;

public class RecursiveTaskTest {
    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool(4);
        MyRecursiveTask task = new MyRecursiveTask(128);
        long mergerResult = pool.invoke(task);
        System.out.println("计算的合并结果为" + mergerResult);
    }
}
