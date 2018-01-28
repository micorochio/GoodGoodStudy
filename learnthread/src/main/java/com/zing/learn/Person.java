package com.zing.learn;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Stream;

public class Person {
    public synchronized void workingWithJava() {
        System.out.println(Thread.currentThread().getName());
        System.out.println("System.out.println(\"Hello World\");\n");
        workingWithC();

    }

    public synchronized void workingWithC() {
        System.out.println(Thread.currentThread().getName());
        System.out.println("printf(\"Hello World\");\n");
    }
}

class Runner {
    public static void main(String[] args) {

        Big b = new Big();
        Sub s = new Sub();
        int times = 1000;
//        Thread A1 = new Thread(() -> b.eat(times));
//        Thread A2 = new Thread(() -> b.eat(times));
//        System.out.println("eating:BigFood");
//        A1.start();
//        A2.start();
//        Thread B1 = new Thread(() -> s.eat(times));
//        Thread B2 = new Thread(() -> s.eat(times));
//        System.out.println("Sub eating:SmallFood");
//        B1.start();
//        B2.start();

//        int[] nums = {2, 3, 4, 5, 6};
//        System.out.println(
//                Arrays.stream(nums)
//                        .map(i -> i % 2 == 0 ? i : 0)
//                        .reduce(0, Integer::sum)
//        );

//        List<List<Integer>> ll =
//                Arrays.asList(
//                        Arrays.asList(1, 2, 3),
//                        Arrays.asList(11, 22, 33),
//                        Arrays.asList(0xF1, 0xF2, 0xF3)
//                );
//
//        ll.stream()
//                .flatMap(list -> list.stream())
//                .map(i -> 2 * i)
//                .forEach(i -> System.out.println(i));
//
//
//


        Stream<Integer> trans = Stream.of(11, 9, 2, 13, 1, 2, 99, 54, 23, 66, 70, 23, 46, 50, 100, 10, 24, 18, 19, 2);
        trans.map(i->{
            System.out.println(i);
            return i;
        });
//        IntSummaryStatistics all = trans.skip(5)
//                .limit(10)
//                .filter(i -> i >= 50)
//                .mapToInt(i->i)
//                .summaryStatistics();
//        System.out.println(all.getAverage());

    }
}

class Big {
    public synchronized void eat(int t) {
        for (; t > 0; t--) {
            System.out.println("吃" + (1000 - t));
        }
        System.out.println("嗝");

    }
}

class Sub extends Big {
    @Override
    public void eat(int t) {
        for (; t > 0; t--) {
            System.out.println("吃" + (1000 - t));
        }
        System.out.println("没吃完");
    }
}
