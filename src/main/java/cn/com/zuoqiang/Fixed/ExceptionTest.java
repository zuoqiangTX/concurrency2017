package cn.com.zuoqiang.Fixed;

public class ExceptionTest {
    public static void main(String[] args) throws Exception {
       // test1();
        test2();

    }

    //如果不throw的话，这个catch异常处理相当于程序的一个goto跳转，之后的代码继续执行
    public static void  test1() {
        for (int i = 0; i < 10; i++) {
            System.out.println("This is a test" + i);
            if (i == 5) {
                try {
                    int a = i / 0;
                } catch (Exception e) {
                    //e.printStackTrace();
                    System.out.println("error" + e.getMessage());
                }
            }
        }
    }

    //如果你throw异常的话，会执行finally中的代码，其他代码不执行
    public static void test2() throws Exception {
        for (int i = 0; i < 10; i++) {
            if (i == 5) {
                throw new Exception();
            }
            System.out.println("This is a test" + i);
        }
    }
}
