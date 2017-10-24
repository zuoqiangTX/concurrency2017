package cn.com.zuoqiang.test.chapter3;

import java.util.List;
import java.util.concurrent.Exchanger;

public class Producer implements Runnable {
    private List<String> buffer;
    private final Exchanger<List<String>> exchanger;

    public Producer(List<String> buffer, Exchanger<List<String>> exchanger) {
        this.buffer = buffer;
        this.exchanger = exchanger;
    }

    //循环执行10次数据交换
    public void run() {
        int cycle = 1;
        for (int i = 0; i < 10; i++) {
            System.out.printf("Producer : Cycle %d\n", cycle);
            for (int j = 0; j < 10; j++) {
                String message = "Event" + ((i * 10) + j);
                System.out.printf("Producer 生产了字符串: %s\n", message);
                buffer.add(message);
            }
            try {
                buffer = exchanger.exchange(buffer); //交换数据
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Producer buffer的大小: " + buffer.size());
            cycle++;
        }
    }
}
