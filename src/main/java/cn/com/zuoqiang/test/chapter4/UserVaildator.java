package cn.com.zuoqiang.test.chapter4;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class UserVaildator {
    private String name;

    public UserVaildator(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean volidate(String name, String password) {
        Random random = new Random();
        //模拟用户验证的过程
        try {
            long duration = (long) (Math.random() * 10);
            System.out.println(name + "验证了" + duration + "s");
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            return false;
        }
        return random.nextBoolean();
    }
}
