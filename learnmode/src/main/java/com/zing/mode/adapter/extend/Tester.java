package com.zing.mode.adapter.extend;

/**
 * @author zing
 * @date 2018/3/6 18:18
 */
public class Tester {
    public static void main(String[] args) {
        VoltageAdapter adapter = new VoltageAdapter();
        System.out.println("连接电源");
        int r = adapter.power();
        System.out.println("获得电压：" + r);

    }
}
