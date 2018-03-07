package com.zing.mode.template;

import java.util.Arrays;

/**
 * @author zing
 * @date 2018/3/7 11:50
 */
public class CharDisplay extends AbstractDisplay {
    String chars;

    public CharDisplay(String chars) {
        this.chars = chars;
    }

    @Override
    public void open() {
        System.out.println("<<");
    }

    @Override
    public void print() {
        System.out.println(Arrays.toString(chars.toCharArray()));
    }

    @Override
    public void close() {
        System.out.println(">>");
    }
}
