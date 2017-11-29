package cn.com.zuoqiang.Fixed;

public class ConditionTest {
    public static void main(String[] args) {
        int i = 101;
        testVoid(i);
        //当i<100的时候不停打印我在检查
        //当i>100的时候只检查一次，只打印结束
    }

    private static void testVoid(int i) {
        while (i < 100) {
            System.out.println("我在检查");
        }
        System.out.println("结束！");
    }
}
