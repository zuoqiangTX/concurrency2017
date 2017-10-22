package cn.com.zuoqiang.test.chapter1;

import java.util.Date;

public class DataSourceAndNetWorkMain {
    public static void main(String[] args) {
        DataSourceLoader dsLoader = new DataSourceLoader();
        Thread thread1 = new Thread(dsLoader,"DataSourceThread");
        NetworkConnectionLoader connectionLoader = new NetworkConnectionLoader();
        Thread thread2 = new Thread(connectionLoader, "NetworkConnectionLoader");
        thread1.start();
        thread2.start();
        //等待这两个线程的终止,然后主线程才继续执行
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Main configuration has been loader : %s\n", new Date());

    }
}
