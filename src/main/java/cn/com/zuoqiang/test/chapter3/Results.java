package cn.com.zuoqiang.test.chapter3;

public class Results {
    private int data[]; //每行中找到指定数字的字数

    public Results(int size) {
        data = new int[size];
    }

    public void setData(int position, int value) {
        data[position] = value;
    }

    public int[] getData() {
        return data;
    }
}
