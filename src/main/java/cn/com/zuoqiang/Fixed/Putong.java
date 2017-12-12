package cn.com.zuoqiang.Fixed;

public class Putong {
    {
        System.out.println("普通代码块！-->");
    }

    static {
        System.out.println("静态构造方法！-->");
    }

    public Putong() {
        System.out.println("默认构造方法！-->");
    }

    public  void test() {
        {
            System.out.println("普通方法中的代码块！");
        }
    }
}
