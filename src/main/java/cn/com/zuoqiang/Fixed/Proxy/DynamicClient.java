package com.zuoqiang.cn.test.Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class DynamicClient {
    public static void main(String[] args) {
        ICoder coder = new JavaICoder("javaCoder");   //真实对象
        InvocationHandler handler = new CoderDynamicProxy(coder);  //中介类
        ClassLoader classLoader = coder.getClass().getClassLoader();  //生成类加载器
        ICoder proxy = (ICoder) Proxy.newProxyInstance(classLoader, coder.getClass().getInterfaces(), handler);
        //动态产生代理类
        proxy.implDemands("动态代理");
    }
}
