package cn.com.zuoqiang.test.chapter2;

public class CinemaMain {
    public static void main(String[] args) {
        Cinema cinema = new Cinema();
        TicketOffice1 ticketOffice1 = new TicketOffice1(cinema);
        TicketOffcie2 ticketOffcie2 = new TicketOffcie2(cinema);
        Thread thread1 = new Thread(ticketOffice1, "TicketOffice1");
        Thread thread2 = new Thread(ticketOffcie2, "TicketOffice2");
        thread1.start();
        thread2.start();
        //等待这两个线程结束
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Ticket1的余票 ：" + cinema.getVacanciesCinema1());
        System.out.println("Ticket2的余票 ：" + cinema.getVacanciesCinema2());

    }
}
