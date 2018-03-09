package com.zing.mode.factory;

/**
 * @author zing
 * @date 2018/3/9 10:12
 */
public class CollageFactory extends Factory {


    @Override
    protected Student graduated(String name) {
        return new Student(name);
    }

    @Override
    protected void registerDiploma(Student student) {
        System.out.println("恭喜" + student.getName() + "成为大学生！");
    }
}
