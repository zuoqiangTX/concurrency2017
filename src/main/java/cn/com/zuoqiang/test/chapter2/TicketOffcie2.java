package cn.com.zuoqiang.test.chapter2;

public class TicketOffcie2 implements Runnable {
    private Cinema cinema;

    public TicketOffcie2(Cinema cinema) {
        this.cinema = cinema;
    }

    public void run() {
        cinema.sellTicket2(2);
        cinema.sellTicket2(4);
        cinema.sellTicket1(2);
        cinema.sellTicket1(1);
        cinema.returnTicket2(2);
        cinema.sellTicket1(3);
        cinema.sellTicket2(2);
        cinema.sellTicket2(2);

    }
}
