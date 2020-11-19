package com.github.lazyf1sh.sandbox.java.jcl.java.util.optional;

import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * The default implementation of smth.
 *
 * @author Ivan Kopylov
 */
public class Dsad
{
    @Test
    public void streamWithoutTerminalOperationIsNotExecuted()
    {
        AtomicBoolean result = new AtomicBoolean(false);
        Stream.of("a", "b").map(Function.identity()).peek(s -> {
            System.out.println(s);
            result.set(true);

        });
        Assert.assertFalse(result.get());
    }
}
