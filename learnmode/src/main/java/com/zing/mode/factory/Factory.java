package com.zing.mode.factory;

/**
 * @author zing
 * @date 2018/3/9 10:16
 */
public abstract class Factory {
    public final Student create(String name) {
        Student product = graduated(name);

        registerDiploma(product);

        return product;
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
