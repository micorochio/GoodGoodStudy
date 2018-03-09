package com.zing.mode.factory;

/**
 * @author zing
 * @date 2018/3/9 10:23
 */
public class Tester {
    public static void main(String[] args) {
        Factory factory = new CollageFactory();

        Student s1 = factory.create("小名");
        Student s2 = factory.create("小早");

        s1.findJob();
        s2.findJob();
    }


}
