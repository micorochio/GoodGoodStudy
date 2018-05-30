package com.zing.mode.prototype;

/**
 * @author zing
 * @date 2018/3/14 15:41
 */
public class Tester {
    public static void main(String[] args) {
        Manager manager = new Manager();
        UnderlinePen underlinePen = new UnderlinePen('~');
        MessageBox messageBox = new MessageBox('*');
        MessageBox messageBoxS = new MessageBox('.');

        manager.register("strong", underlinePen);
        manager.register("mbox", messageBox);
        manager.register("sbox", messageBoxS);


        Product p1 = manager.create("strong");
        p1.use("Dr Wu 555555!");


        Product p2 = manager.create("mbox");
        p2.use("Dr Wu 555555!");


        Product p3 = manager.create("sbox");
        p3.use("Dr Wu 555555!");


    }
}
