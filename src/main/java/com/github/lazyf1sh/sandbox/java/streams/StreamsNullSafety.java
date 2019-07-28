package com.github.lazyf1sh.sandbox.java.streams;

import java.util.List;

/**
 * @author Ivan Kopylov
 */
public class StreamsNullSafety
{
    public static void main(String[] args)
    {
        List<String> myList = null;
        myList.stream().forEach(System.out::println);
    }
}
