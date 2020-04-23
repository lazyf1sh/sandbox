package com.github.lazyf1sh.sandbox.java.jcl.java.util.function;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Assert;
import org.junit.Test;

import com.github.lazyf1sh.sandbox.java.jcl.util.function.PredicateCreator;

/**
 * @author Ivan Kopylov
 */
public class PredicateExample
{
    @Test
    public void run()
    {
        Stream<String> myStream = Stream.of("a", "b", "c");
        List<String> result = myStream.filter(PredicateCreator.build(a -> a.equalsIgnoreCase("a"))).collect(Collectors.toList());
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("a", result.get(0));
    }
}
