package com.java.lambda;


import java.util.Arrays;
import java.util.List;

public class StreamTest1 {
    public static void main(String[] args) {
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
