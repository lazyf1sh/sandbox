package com.github.lazyf1sh.sandbox.java.jcl.java.util.stream;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Ivan Kopylov
 */
public class OrderOfOperationsMatters
{

    @Test
    public void main()
    {
        orderOfOperationsMatters();
    }

    public static void orderOfOperationsMatters()
    {
        List<String> result1 = Stream.of("1", "22", "333")
                .map(s -> s + "-postfix")
                .filter(s -> s.length() > 1)
                .collect(Collectors.toList());

        List<String> result2 = Stream.of("1", "22", "333")
                .filter(s -> s.length() > 1)
                .map(s -> s + "-postfix")
                .collect(Collectors.toList());

        Assert.assertEquals(3, result1.size());
        Assert.assertEquals(2, result2.size());
    }

}
