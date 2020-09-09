package com.github.lazyf1sh.sandbox.java.jcl.java.util.stream;

import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

/**
 * @author Ivan Kopylov
 */
public class Reducer
{
    @Test
    public void run1()
    {
        Optional<Integer> reduced = Stream.of(1, 2, 3)
                .reduce(new BinaryOperator<Integer>()
                {
                    @Override
                    public Integer apply(Integer previous, Integer current)
                    {
                        return current > previous ? current : previous;
                    }
                });
        Assert.assertTrue(reduced.isPresent());
        reduced.ifPresent(value -> Assert.assertEquals(Integer.valueOf(3), value));
    }

    @Test
    public void run2()
    {
        Optional<Integer> reduced = Stream.of(1)
                .reduce(new BinaryOperator<Integer>()
                {
                    @Override
                    public Integer apply(Integer previous, Integer current)
                    {
                        System.out.println("Called"); //not called for one element
                        return current > previous ? current : previous;
                    }
                });
        Assert.assertTrue(reduced.isPresent());
        reduced.ifPresent(value -> Assert.assertEquals(Integer.valueOf(1), value));
    }
}
