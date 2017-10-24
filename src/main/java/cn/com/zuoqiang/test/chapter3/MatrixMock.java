package cn.com.zuoqiang.test.chapter3;

import java.util.Random;

public class MatrixMock {
    private int[][] data;

    public MatrixMock(int size, int length, int number) {
        int count = 0;
        data = new int[size][length];
        Random random = new Random();
        //用随机数字为矩阵赋值
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < length; j++) {
                data[i][j] = random.nextInt(10);
                if (data[i][j] == number) {
                    count++;
                }
            }
        }
        System.out.printf("Mock %d ocurrences of %d number ", count, number);
    }

    //寻找矩阵行号
    public int[] getRow(int row) {
        if ((row >= 0) && (row < data.length)) {
            return data[row];
        }
        return null;
    }
}
