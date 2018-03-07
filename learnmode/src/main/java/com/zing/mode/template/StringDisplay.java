package com.zing.mode.template;

import com.sun.xml.internal.ws.util.StringUtils;

/**
 * @author zing
 * @date 2018/3/7 11:55
 */
public class StringDisplay extends AbstractDisplay {

    private String strings;

    public StringDisplay(String strings) {
        this.strings = strings;
    }

    @Override
    public void open() {
        System.out.println("+------------------+");
    }

    @Override
    public void print() {
        System.out.println(padding(strings, 18, ' ').substring(0, 18));
    }

    private String padding(String strings, int length, char c) {
        if (strings.length() < length) {
            int l = length - strings.length();
            char[] a = new char[l];
            for (int i = 0; i < l; i++) {
                a[i] = c;
            }

            return new String(a);
        }
        return strings.substring(0, 18);
    }

    @Override
    public void close() {
        System.out.println("+------------------+");
    }
}
