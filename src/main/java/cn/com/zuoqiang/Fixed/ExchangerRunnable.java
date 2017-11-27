package cn.com.zuoqiang.Fixed;

import java.util.concurrent.Exchanger;

public class ExchangerRunnable implements Runnable {
    Exchanger exchanger = null;
    Object object = null;

    public ExchangerRunnable(Exchanger exchanger, Object object) {
        this.exchanger = exchanger;
        this.object = object;
    }

    public void run() {
        try {
            Object preious = this.object;
            this.object = this.exchanger.exchange(object);
            System.out.println(Thread.currentThread().getName() + "exchanged " + preious + " for " + this.object);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
