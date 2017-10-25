package cn.com.zuoqiang.test.chapter4;

import java.util.concurrent.Callable;

public class TaskValidator implements Callable<String> {
    private String name;
    private String password;
    private UserVaildator vaildator;

    public TaskValidator(String name, String password, UserVaildator vaildator) {
        this.name = name;
        this.password = password;
        this.vaildator = vaildator;
    }

    public String call() throws Exception {
        if (!vaildator.volidate(name, password)) {
            System.out.printf("%s : 用户不能被找到", vaildator.getName());
            throw new Exception("Error validating user.");
        }
        System.out.printf("%s : 用户被找到了", vaildator.getName());
        return vaildator.getName();
    }
}
