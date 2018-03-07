package com.zing.mode.adapter.insrust;

/**
 * @author zing
 * @date 2018/3/7 11:23
 */
public class Tester {
    public static void main(String[] args) {
        Printer p = new BannerPrinter("Adapter");
        p.printStrong();
        p.printWeak();
    }
}
