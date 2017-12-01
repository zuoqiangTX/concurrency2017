package com.zuoqiang.cn.test.Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

//代理类和委托类之间的中介类
public class CoderDynamicProxy implements InvocationHandler {
    private ICoder coder;    //被代理的真实实例

    public CoderDynamicProxy(ICoder coder) {
        this.coder = coder;
    }

    //调用被代理的方法
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(System.currentTimeMillis());
        Object result = method.invoke(coder, args);
        System.out.println(System.currentTimeMillis());
        return result;
    }
}
