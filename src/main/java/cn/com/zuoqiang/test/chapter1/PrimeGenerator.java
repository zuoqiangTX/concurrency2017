package cn.com.zuoqiang.test.chapter1;

public class PrimeGenerator extends Thread {
    public void run() {
        long number = 1L;
        while (true) {
            if (isPrimeNumber(number)) {
                System.out.printf("Number %d is a Prime \n", number);
            }
            if (Thread.currentThread().isInterrupted()) {  //判断当前线程是否中断，不能改变interuppted属性的值
                System.out.printf("The Prime Generator has been Interrupted");
                return;
            }
            number++;
        }
    }

    private boolean isPrimeNumber(long number) { //判断是否是素数
        if (number <= 2) {
            return true;
        }
        for (long i = 2; i < number; i++) {
            if ((number % i) == 0) {
                return false;
            }
        }
        return true;
    }
}
