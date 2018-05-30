package com.zing.mode.prototype;

/**
 * @author zing
 * @date 2018/3/9 11:01
 */
public interface Product extends Cloneable {
    void use(String s);

    Product createClone();
}
