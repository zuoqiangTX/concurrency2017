package cn.com.zuoqiang.test.chapter6;

public class Company implements Runnable {
    private Account account;

    public Company(Account account) {
        this.account = account;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            account.addAmount(1000);
        }
    }
}
