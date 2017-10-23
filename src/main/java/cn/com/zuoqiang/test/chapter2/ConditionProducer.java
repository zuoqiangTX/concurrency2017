package cn.com.zuoqiang.test.chapter2;

public class ConditionProducer implements Runnable {
    private FileMock fileMock;
    private Buffer buffer;

    public ConditionProducer(FileMock fileMock, Buffer buffer) {
        this.fileMock = fileMock;
        this.buffer = buffer;
    }

    //读取所有的数据行并用insert读到的行数插入缓冲区，读完通知缓冲区停止生成更多的行
    public void run() {
        buffer.setPendingLines(true);
        while (fileMock.hasMoreLines()) {
            String lines = fileMock.getLine();
            buffer.insert(lines);
        }
        buffer.setPendingLines(false);
    }
}
