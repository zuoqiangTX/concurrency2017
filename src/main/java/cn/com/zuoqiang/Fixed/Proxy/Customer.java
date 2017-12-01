package com.zuoqiang.cn.test.Proxy;

public class Customer {
    public static void main(String[] args) {
        ICoder javaCoder = new JavaICoder("javaCoder");
        ICoder proxy = new CoderProxy(javaCoder);
        proxy.implDemands("使用静态代理");
    }
}
