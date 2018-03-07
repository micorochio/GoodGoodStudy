package com.zing.mode.adapter.insrust;

/**
 * @author zing
 * @date 2018/3/7 10:49
 */
public class Banner {
    private String slogan;

    public Banner(String slogan) {
        this.slogan = slogan;
    }


    public void showWithParten() {
        System.out.println("(" + slogan + ")");
    }

    public void showWithAster() {
        System.out.println("*" + slogan + "*");
    }
}
