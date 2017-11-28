package cn.com.zuoqiang.test.chapter5;

import java.util.concurrent.ForkJoinPool;

public class RescursiveTest {
    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool(4);
        MyRecursiveAction action = new MyRecursiveAction(24);
        pool.invoke(action);
    }
}
