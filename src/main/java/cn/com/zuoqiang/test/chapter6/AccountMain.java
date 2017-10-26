package cn.com.zuoqiang.test.chapter6;

public class AccountMain {
    public static void main(String[] args) {
        Account account = new Account();
        account.setBalance(1000);
        Company company = new Company(account);
        Thread companyThread = new Thread(company);
        Bank bank = new Bank(account);
        Thread bankThread = new Thread(bank);
        System.out.println("账户余额为：" + account.getBalance());
        companyThread.start();
        bankThread.start();
        try {
            companyThread.join();
            bankThread.join();
            System.out.printf("Account : Final Banlance : %d\n", account.getBalance());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
