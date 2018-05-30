package com.zing.mode.prototype;

/**
 * @author zing
 * @date 2018/3/9 11:14
 */
public class MessageBox implements Product {
    private char decodechar;

    public MessageBox(char decodechar) {
        this.decodechar = decodechar;
    }

    @Override
    public void use(String s) {
        int length = s.getBytes().length;
        length += 4;
        for (int i = 0; i < length; i++) {
            System.out.print(decodechar);
        }
        System.out.println("");
        System.out.println(decodechar + " " + s + " " + decodechar);
        for (int i = 0; i < length; i++) {
            System.out.print(decodechar);
        }
        System.out.println("");

    }

    @Override
    public Product createClone() {
        Product p = null;
        try {
            p = (Product) clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return p;
    }

}
