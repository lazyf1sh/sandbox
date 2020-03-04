package com.github.lazyf1sh.sandbox.java.mechanics.lambdas;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * @author Ivan Kopylov
 */
public class BasicLambdaExamples
{
    @Test
    public void run()
    {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        numbers.forEach((Integer value) -> System.out.println(value));
        System.out.println("--");
        numbers.forEach(value -> System.out.println(value));
        System.out.println("--");
        numbers.forEach(System.out::println);
    }
}
