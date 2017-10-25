package cn.com.zuoqiang.test.chapter4;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class FactorialCalculator implements Callable<Integer> {
    private Integer number;  //存放即将用来计算的数字

    public FactorialCalculator(Integer number) {
        this.number = number;
    }

    public Integer call() throws Exception {
        int result = 0;
        if ((number == 0) || (number == 1)) {
            result = 1;
        } else {
            for (int i = 2; i < number; i++) {
                result *= i;
                TimeUnit.MILLISECONDS.sleep(20);
            }
        }
        System.out.printf("%s : %d\n", Thread.currentThread().getName(), result);
        return result;
    }
}
