package cn.com.zuoqiang.test.chapter2;

import javax.xml.transform.Templates;

public class Account {
    private double balance;

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    //将传入的数量加入到余额中
    public synchronized void addAmount(double amount) {
        double temp = balance;
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        temp += amount;
        balance = temp;
    }

    //将传入的数量从余额中扣除
    public synchronized void subtractAmount(double amount) {
        double temp = balance;
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        temp -= amount;
        balance = temp;
    }
}
