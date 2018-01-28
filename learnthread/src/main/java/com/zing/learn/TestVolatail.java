package com.zing.learn;

public class TestVolatail {
    public static volatile int added = 0;

    public static void increase() {
        added++;//++ 操作是先取出来，然后再加一，如果想线程安全，试试juc里面的atomic包下的类

    }

    public static final int ADD_ACCOUNTER = 10;

    public static void main(String[] args) {
        Thread t[] = new Thread[ADD_ACCOUNTER];
        for (int i = 0; i < ADD_ACCOUNTER; i++) {
            t[i] = new Thread(() -> {
                for (int m = 0; m < 10000; m++) {
                    increase();
                }
            });
            t[i].start();
        }

        while (Thread.activeCount() > 1) {
            Thread.yield();
        }

        System.out.println("最终累加值：" + added);

    }

}
