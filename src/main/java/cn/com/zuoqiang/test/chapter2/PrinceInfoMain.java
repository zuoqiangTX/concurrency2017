package cn.com.zuoqiang.test.chapter2;

public class PrinceInfoMain {
    public static void main(String[] args) {
        PricesInfo pricesInfo = new PricesInfo();
        Reader[] readers = new Reader[5];
        Thread[] threads = new Thread[5];
        for (int i = 0; i < 5; i++) {
            readers[i] = new Reader(pricesInfo);
            threads[i] = new Thread(readers[i]);
        }
        Writer writer = new Writer(pricesInfo);
        Thread threadWriter = new Thread(writer);
        for (int i = 0; i < 5; i++) {
            threads[i].start();
        }
        threadWriter.start();
    }
}
