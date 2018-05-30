package com.zing.mode.factory;

/**
 * @author zing
 * @date 2018/3/8 18:45
 */
public class Student extends Product {


    Student(String name) {
        super(name);
    }

    public void findJob() {
        System.out.println(name + "找不到工作！");
    }
}
