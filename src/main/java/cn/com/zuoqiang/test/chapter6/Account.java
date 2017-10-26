package cn.com.zuoqiang.test.chapter6;

import java.util.concurrent.atomic.AtomicLong;

public class Account {
    private AtomicLong balance;

    public Account() {
        this.balance = new AtomicLong();
    }

    public void setBalance(long balance) {
        this.balance.set(balance);
    }

    public long getBalance() {
        return balance.get();
    }

    public void addAmount(long amount) {
        this.balance.getAndAdd(amount);
    }

    public void subAmount(long amount) {
        this.balance.getAndAdd(-amount);
    }
}
