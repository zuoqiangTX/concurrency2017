package cn.com.zuoqiang.test.chapter3;

import java.util.concurrent.CyclicBarrier;

public class BarrierMain {
    public static void main(String[] args) {
        final int ROWS = 10000;
        final int NUMBERS = 1000;
        final int SEARCH = 5;  //查找5
        final int PARTCIPANTS = 5;
        final int LINES_PARTCIPANTS = 2000;
        MatrixMock mock = new MatrixMock(ROWS, NUMBERS, SEARCH);
        Results results = new Results(ROWS);
        Grouper grouper = new Grouper(results);
        CyclicBarrier barrier = new CyclicBarrier(PARTCIPANTS, grouper);
        Seracher[] seracher = new Seracher[PARTCIPANTS];
        for (int i = 0; i < PARTCIPANTS; i++) {
            seracher[i] = new Seracher(i * LINES_PARTCIPANTS, (i * LINES_PARTCIPANTS) + LINES_PARTCIPANTS, mock, results, 5, barrier);
            Thread thread = new Thread(seracher[i]);
            thread.start();
        }
        System.out.println("Main 线程结束！");
    }
}
