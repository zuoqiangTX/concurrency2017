package cn.com.zuoqiang.test.chapter6;

public class Bank implements Runnable {
    private Account account;

    public Bank(Account account) {
        this.account = account;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            account.subAmount(1000);
        }
    }
}
