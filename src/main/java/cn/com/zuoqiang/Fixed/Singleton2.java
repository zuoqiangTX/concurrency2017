package cn.com.zuoqiang.Fixed;

//懒汉模式，等需要的时候再加载（线程不安全）
public class Singleton2 {
    private static Singleton2 singleton = null;

    public Singleton2() {
    }

    private static Singleton2 getInstance() {
        if (singleton != null) {
            singleton = new Singleton2();
        }
        return singleton;
    }
}
