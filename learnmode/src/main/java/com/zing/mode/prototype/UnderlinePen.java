package com.zing.mode.prototype;

/**
 * @author zing
 * @date 2018/3/9 11:04
 */
public class UnderlinePen implements Product {

    char ulchar;

    public UnderlinePen(char ulchar) {
        this.ulchar = ulchar;
    }

    @Override
    public void use(String s) {
        System.out.println("\"" + s + "\"");
        int length = s.length();
        System.out.print(" ");
        for (int i = 0; i < length; i++) {
            System.out.print(ulchar);
        }
        System.out.println(" ");

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
