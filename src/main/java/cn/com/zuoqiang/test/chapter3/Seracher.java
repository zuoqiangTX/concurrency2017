package cn.com.zuoqiang.test.chapter3;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Seracher implements Runnable {
    private int firstRow;
    private int lastRow;
    private MatrixMock mock;
    private Results results;
    private int number; //查找的数字
    private final CyclicBarrier cyclicBarrier;

    public Seracher(int firstRow, int lastRow, MatrixMock mock, Results results, int number, CyclicBarrier cyclicBarrier) {
        this.firstRow = firstRow;
        this.lastRow = lastRow;
        this.mock = mock;
        this.results = results;
        this.number = number;
        this.cyclicBarrier = cyclicBarrier;
    }

    //查找数字,使用内部变量来存放每行查找到的数字
    public void run() {
        int count;
        System.out.printf("%s : 处理行数从 %d 到 %d .\n", Thread.currentThread().getName(), firstRow, lastRow);
        for (int i = firstRow; i < lastRow; i++) {
            int[] row = mock.getRow(i);
            count = 0;
            for (int j = 0; j < row.length; j++) {
                if (row[j] == number) {
                    count++;
                }
            }
            results.setData(i, count);
        }
        System.out.printf("%s lines 处理完毕\n", Thread.currentThread().getName());
        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
