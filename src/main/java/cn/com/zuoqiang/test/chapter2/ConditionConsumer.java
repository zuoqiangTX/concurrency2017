package cn.com.zuoqiang.test.chapter2;

import java.util.Random;

public class ConditionConsumer implements Runnable {
    private Buffer buffer;

    public ConditionConsumer(Buffer buffer) {
        this.buffer = buffer;
    }

    //获取一行缓冲区进行处理
    public void run() {
        while (buffer.hasPendingLines()) {
            String line = buffer.get();
            processLine(line);
        }
    }

    private void processLine(String line) {
        //模拟10毫秒以内的数据处理
        Random random = new Random();
        try {
            Thread.sleep(random.nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
