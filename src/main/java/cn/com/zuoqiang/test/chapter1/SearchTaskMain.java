package cn.com.zuoqiang.test.chapter1;

import java.util.concurrent.TimeUnit;

public class SearchTaskMain {
    public static void main(String[] args) {
        ThreadGroup threadGroup = new ThreadGroup("Searcher");
        Result result = new Result();
        SearchTask searchTask = new SearchTask(result);
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(threadGroup, searchTask);
            thread.start();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.printf("Number of Thread : %d\n", threadGroup.activeCount());
        System.out.printf("Information about the Thread Group.\n");
        threadGroup.list();
        Thread[] threads = new Thread[threadGroup.activeCount()]; //获取线程组包含的线程数目
        threadGroup.enumerate(threads); //获取线程组包含的线程列表
        for (int i = 0; i < threadGroup.activeCount(); i++) {
            System.out.printf("Thread %s : %s\n", threads[i].getName(), threads[i].getState());
        }
        waitFinish(threadGroup);
        threadGroup.interrupt();

    }

    private static void waitFinish(ThreadGroup threadGroup) {
        while (threadGroup.activeCount() > 9) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
