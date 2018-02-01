package com.zing.java;


import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class StreamTest1 {
    @Test
    public void sourceNotChange() {
        List<String> names = Arrays.asList("zing", "wang", "zhen", "max");
        System.out.println("\nthe source data-------------------");
        System.out.println(names);
        System.out.println("\nthe stream data-------------------");
        names.stream().map(i -> {
            i = i + "_2 ";
            return i;
        }).forEach(System.out::print);
        System.out.println("\n");

    }

}
