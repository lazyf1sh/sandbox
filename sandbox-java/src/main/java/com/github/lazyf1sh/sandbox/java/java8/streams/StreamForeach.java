package com.github.lazyf1sh.sandbox.java.java8.streams;

import java.util.Random;

/**
 * @author Ivan Kopylov
 */
public class StreamForeach
{
    public static void main(String[] args) {
        Random random = new Random();
        random.ints().limit(10).forEach(System.out::println);
    }
}
