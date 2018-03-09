package com.zing.mode.factory;

/**
 * @author zing
 * @date 2018/3/8 18:45
 */
public class Student {
    private String name;

    Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void findJob() {
        System.out.println(name + "找不到工作！");
    }
}
