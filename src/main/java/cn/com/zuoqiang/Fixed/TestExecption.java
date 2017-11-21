package cn.com.zuoqiang.Fixed;

import java.io.IOException;

public class TestExecption {
    private void fun1() throws IOException {
        throw new IOException("level 1 exception");
    }

    private void fun2() {
        try {
            fun1();
        } catch (IOException e) {
            throw new RuntimeException("level 2 exception", e);
        }
    }

    public static void main(String[] args) {
        try {
            new TestExecption().fun2();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
