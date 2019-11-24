package com.github.lazyf1sh.sandbox.java.java8;

import java.util.function.Function;

/**
 * functional interface
 */
public class MethodReferenceExample
{
    public static void main(String[] args) {
        Function<Double, Double> square = (Double x) -> x * x;
        Function<Double, Double> square2 = Foo::square;

        double d1 = square.apply(2d);
        double d2 = square2.apply(4d);

        System.out.println(d1);
        System.out.println(d2);

    }
}
