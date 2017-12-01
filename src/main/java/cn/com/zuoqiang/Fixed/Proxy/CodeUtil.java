package com.zuoqiang.cn.test.Proxy;

import sun.misc.ProxyGenerator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CodeUtil {
    public static void main(String[] args) throws IOException {
        byte[] classFile = ProxyGenerator.generateProxyClass("TestProxyGen", JavaICoder.class.getInterfaces());
        File file = new File("./TestProxyGen.class");
        System.out.println(file.getPath());
        FileOutputStream outputStream = new FileOutputStream(file);
        outputStream.write(classFile);
        outputStream.flush();
        outputStream.close();
    }
}
