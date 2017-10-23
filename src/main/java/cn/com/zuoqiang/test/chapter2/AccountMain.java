package cn.com.zuoqiang.test.chapter2;

import javax.smartcardio.CommandAPDU;

public class AccountMain {
    public static void main(String[] args) {
        Account account = new Account();
        account.setBalance(1000);
        Company company = new Company(account);
        Thread companyThread = new Thread(company);
        Bank bank = new Bank(account);
        Thread bankThread = new Thread(bank);
        System.out.printf("Account : 初始余额为 ：%f\n", account.getBalance());
        companyThread.start();
        bankThread.start();
        //等待这两个线程完成任务
        try {
            companyThread.join();
            bankThread.join();
            System.out.printf("Account : 最终的余额为 ：%f\n", account.getBalance());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
