package cn.com.zuoqiang.Fixed;

//饿汉模式，直接加载（线程安全，缺点是比较占用资源，如果一直没使用的话）
public class Singleton {
    private static final Singleton single = new Singleton();

    public Singleton() {
    }

    public static Singleton getSingle() {
        return single;
    }
}
