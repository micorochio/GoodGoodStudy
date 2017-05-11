package com.zing.learn;

/**
 * Created by zing on 2017/4/18.
 */
public class SelfStart implements Runnable {
    public void run() {
        System.out.println("hi");
    }

    public static void main(String[] args) {
        SelfStart ss = new SelfStart();
        Thread thread = new Thread(ss);
        thread.start();
    }
}
