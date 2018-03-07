package com.zing.mode.template;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @author zing
 * @date 2018/3/7 11:50
 */
public class CharDisplay extends AbstractDisplay {
    String chars;
    private char[] flet;

    public CharDisplay(String chars) {
        flet = new char[chars.length()];
        IntStream.range(0, chars.length()).forEach(i -> flet[i] = '-');
        this.chars = chars;
    }

    @Override
    public void open() {
        System.out.println("<" + new String(flet) + ">");
    }

    @Override
    public void print() {
        System.out.println("|" + Arrays.toString(chars.toCharArray()) + "|");
    }

    @Override
    public void close() {
        System.out.println("<" + new String(flet) + ">");
    }
}
