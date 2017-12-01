package com.zuoqiang.cn.test.Proxy;

public class JavaICoder implements ICoder {
    private String name;

    public JavaICoder(String name) {
        this.name = name;
    }

    @Override
    public void implDemands(String dmandName) {
        System.out.println(name + " implemented demand : " + dmandName + " in JAVA!");
    }
}
