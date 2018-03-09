package com.java.lambda;

import java.util.stream.IntStream;

/**
 * @author zing
 * @date 2018/3/7 20:02
 */
public class StreamTest2 {
    public static void main(String[] args) {
//        产生 [0,100)
        IntStream.range(0, 100).forEach(System.out::println);
    }
}
