package cn.com.zuoqiang.test.chapter2;

public class Reader implements Runnable {
    private PricesInfo pricesInfo;

    public Reader(PricesInfo pricesInfo) {
        this.pricesInfo = pricesInfo;
    }

    //循环读取两个价格值10次
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.printf("%s :Price 1 : %f\n",Thread.currentThread().getName(), pricesInfo.getPrice1());
            System.out.printf("%s :Price 2 : %f\n",Thread.currentThread().getName(), pricesInfo.getPrice2());

        }

    }
}
