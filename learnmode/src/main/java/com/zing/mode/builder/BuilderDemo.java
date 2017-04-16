package com.zing.mode.builder;

/**
 * Created by zing on 2017/4/9.
 */
public class BuilderDemo {
    public static void main(String[] args) {
        Builder builder = new GameBuilder();
        Director director = new Director(builder);
        director.construct();

        System.out.println(builder.retrieveResult());

    }
}

interface Builder {
    public void builderPart1();

    public void builderPart2();

    public Product retrieveResult();

}

class Product {
    private String part1;
    private String part2;

    public String getPart1() {
        return part1;
    }

    public void setPart1(String part1) {
        this.part1 = part1;
    }

    public String getPart2() {
        return part2;
    }

    public void setPart2(String part2) {
        this.part2 = part2;
    }

    @Override
    public String toString() {
        return "Product{" +
                "part1='" + part1 + '\'' +
                ", part2='" + part2 + '\'' +
                '}';
    }
}

class Director {
    Builder builder = null;

    public Director(Builder b) {
        this.builder = b;
    }

    public void construct(){
        builder.builderPart1();
        builder.builderPart2();
    }
}

class GameBuilder implements Builder{
    private Product product = new Product();

    @Override
    public void builderPart1() {
        product.setPart1("编号：9527");
    }

    @Override
    public void builderPart2() {
        product.setPart1("名称：守望先锋");
    }

    @Override
    public Product retrieveResult() {
        return product;
    }
}