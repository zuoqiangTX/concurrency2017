package cn.com.zuoqiang.Fixed;
//线程安全的静态内部类

public class Singleton3 {
    private static class SingletonHolder {
        private static final Singleton3 single = new Singleton3();

        public SingletonHolder() {
        }
    }

    public Singleton3() {
    }

    public synchronized static Singleton3 getInstance() {
        return SingletonHolder.single;
    }
}
