package com.zing.mode.iterator;

/**
 * @author zing
 * @date 2018/3/6 15:29
 */
public interface Iterator<T> {
    /**
     * 判断是否终止
     *
     * @return 是否有下一个元素
     */
    boolean hasNext();

    /**
     * 获取下一个元素
     *
     * @return 下一个元素
     */
    T next();
}
