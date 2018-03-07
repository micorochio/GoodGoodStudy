package com.zing.mode.template;

import java.util.stream.IntStream;

/**
 * @author zing
 * @date 2018/3/7 11:37
 */
public abstract class AbstractDisplay {
    public abstract void open();

    public abstract void print();

    public abstract void close();

    public void display() {
        open();
        IntStream.range(1, 5).forEach(i -> print());
        close();
    }
}
