package cn.com.zuoqiang.test.chapter3;

//计算查找到的总次数
public class Grouper implements Runnable {
    private Results results;

    public Grouper(Results results) {
        this.results = results;
    }

    //计算结果类数组中查找的次数
    public void run() {
        int finalResults = 0;
        System.out.println("Grouper : processing results...");
        int[] data = results.getData();
        for (int number : data) {
            finalResults += number;
        }
        System.out.printf("Grouper : 最后的结果为 : " + finalResults);

    }
}
