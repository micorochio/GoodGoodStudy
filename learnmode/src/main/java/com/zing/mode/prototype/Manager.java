package com.zing.mode.prototype;

import java.util.HashMap;

/**
 * @author zing
 * @date 2018/3/9 11:01
 */
public class Manager {
    HashMap<String, Product> showCase = new HashMap<>();

    public void register(String name, Product proto) {
        showCase.put(name, proto);
    }

    public Product create(String name) {
        return showCase.get(name).createClone();
    }

}
