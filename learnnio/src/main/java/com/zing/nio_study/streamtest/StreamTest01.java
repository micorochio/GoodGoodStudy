package com.zing.nio_study.streamtest;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest01 {
    public static void main(String[] args) {
        int [] source = {1,2,3,4,5,6};
        IntStream s = Arrays.stream(source);

        List list = Arrays.asList(1,2,3,4,5);
        Stream stream = list.stream();

        IntStream stream2 = IntStream.range(1,10);

        Stream<String> s4 = Stream.of("hello","Nice","To","See","U");

        List<String> all = Arrays.asList("hjas","asds","ewrt","ghkw");
        all.stream().map(String::toUpperCase).forEach(System.out::println);

        Stream.iterate(1,item->item+2).limit(6)
                .filter(i->i>2).skip(2).limit(2).mapToInt(i->i*2).sum();
    }
}
