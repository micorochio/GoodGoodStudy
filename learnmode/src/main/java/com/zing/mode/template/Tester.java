package com.zing.mode.template;

/**
 * @author zing
 * @date 2018/3/7 16:07
 */
public class Tester {
    public static void main(String[] args) {
        AbstractDisplay d1 = new StringDisplay("bababalalala");
        AbstractDisplay d2 = new CharDisplay("cjyzs slyzm");

        d1.display();
        d2.display();
    }
}
