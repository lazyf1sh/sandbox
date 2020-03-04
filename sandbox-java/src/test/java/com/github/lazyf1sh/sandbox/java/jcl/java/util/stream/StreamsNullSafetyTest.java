package com.github.lazyf1sh.sandbox.java.jcl.java.util.stream;

import java.util.List;

import org.junit.Test;

/**
 * Purpose of this example: to show that it is not safe to get stream from null object
 * @author Ivan Kopylov
 */
public class StreamsNullSafetyTest
{
    @Test(expected = NullPointerException.class)
    public void run()
    {
        List<String> myList = null;
        myList.stream().forEach(System.out::println);
    }
}
