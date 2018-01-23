package cn.com.zuoqiang.Quick;

public class ZeroCount {
    public static void main(String[] args) {
        System.out.println(countFactZeros(100));
    }

    private static int countFactZeros(int n) {
        int count = 0;
        for (int i = 5; n / i > 0; i *= 5) {
            count += n / i;
        }
        return count;
    }
}
