package com.zuoqiang.cn.test.Proxy;

public class CoderProxy implements ICoder {
    private ICoder coder;

    public CoderProxy(ICoder coder) {
        this.coder = coder;
    }

    @Override
    public void implDemands(String dmandName) {
        if (dmandName.startsWith("Add")) {
            System.out.println("No longer receive 'Add' demand");
            return;
        }
        coder.implDemands(dmandName);
    }
}
