package cn.com.zuoqiang.test.chapter1;

//抛出运行时异常(Unchecked Exception)的线程类
public class Task implements Runnable {
    public void run() {
        int numerr = Integer.parseInt("TTT");
    }
}
