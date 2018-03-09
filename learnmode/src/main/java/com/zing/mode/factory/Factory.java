package com.zing.mode.factory;

/**
 * @author zing
 * @date 2018/3/9 10:16
 */
public abstract class Factory {
    public final Student create(String name) {
        Student collegeStudent = graduated(name);

        registerDiploma(collegeStudent);

        return collegeStudent;
    }

    /**
     * 毕业了
     *
     * @param name 名字
     * @return
     */
    protected abstract Student graduated(String name);

    /**
     * 注册文凭
     *
     * @param student 学生
     */
    protected abstract void registerDiploma(Student student);

}
