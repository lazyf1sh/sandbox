package com.github.lazyf1sh.sandbox.java.jcl.java.util.stream;

import org.junit.Test;

import java.util.Random;

/**
 * @author Ivan Kopylov
 */
public class StreamForeach
{
    @Test
    public void main()
    {
        Random random = new Random();
        random.ints().limit(10).forEach(System.out::println);
    }
}
