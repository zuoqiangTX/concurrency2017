package cn.com.zuoqiang.test.chapter1;

import java.lang.Thread.UncaughtExceptionHandler;

//实现处理运行时异常的类
public class ExceptionHandler implements UncaughtExceptionHandler {
    public void uncaughtException(Thread t, Throwable e) {
        System.out.printf("An exception has been captured\n");
        System.out.printf("Thread : %s\n", t.getId());
        System.out.printf("Exception : %s : %s\n", e.getClass().getName(), e.getMessage());
        System.out.printf("Stack Trace :\n");
        e.printStackTrace(System.out);
        System.out.printf("Thread Status : %s\n", t.getState());
    }
}
