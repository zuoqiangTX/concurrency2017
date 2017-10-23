package cn.com.zuoqiang.test.chapter2;

public class ConditionMain {
    public static void main(String[] args) {
        FileMock fileMock = new FileMock(100, 10);
        Buffer buffer = new Buffer(20);
        ConditionProducer producer = new ConditionProducer(fileMock, buffer);
        ConditionConsumer[] consumer = new ConditionConsumer[3];
        Thread threadProducer = new Thread(producer, "Producer");
        Thread[] threadConsumer = new Thread[3];
        for (int i = 0; i < 3; i++) {
            consumer[i] = new ConditionConsumer(buffer);
            threadConsumer[i] = new Thread(consumer[i], "Consumer" + i);
        }
        threadProducer.start();
        for (int i = 0; i < 3; i++) {
            threadConsumer[i].start();
        }
    }
}
