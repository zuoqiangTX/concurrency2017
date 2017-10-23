package cn.com.zuoqiang.test.chapter2;

public class Writer implements Runnable {
    private PricesInfo pricesInfo;

    public Writer(PricesInfo pricesInfo) {
        this.pricesInfo = pricesInfo;
    }

    //循环修改两个价格3次
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.printf("Writer : Accept to modify the prices.\n");
            pricesInfo.setPrices(Math.random() * 10, Math.random() * 8);
            System.out.printf("Writer have been modified.\n");
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
