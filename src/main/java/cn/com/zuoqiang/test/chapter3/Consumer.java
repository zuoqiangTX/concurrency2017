package cn.com.zuoqiang.test.chapter3;

import java.util.List;
import java.util.concurrent.Exchanger;

public class Consumer implements Runnable {

    private List<String> buffer;
    private final Exchanger<List<String>> exchanger;

    public Consumer(List<String> buffer, Exchanger<List<String>> exchanger) {
        this.buffer = buffer;
        this.exchanger = exchanger;
    }

    public void run() {
        int cycle = 1;
        for (int i = 0; i < 10; i++) {
            System.out.printf("Consumer : Cycle %d\n", cycle);
            try {
                buffer = exchanger.exchange(buffer); //交换数据
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.printf("Consumer buffer的大小: %d\n", buffer.size());
            for (int j = 0; j < 10; j++) {
                String message = buffer.get(0);
                System.out.println("Consumer 消费了字符串: " +message);
                buffer.remove(0);
            }
        }
    }
}
