package com.github.lazyf1sh.sandbox.java.jcl.java.util.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Ivan Kopylov
 */
public class SynchronizedExample
{
    @Test
    public void run() throws InterruptedException
    {
        ExecutorService service = Executors.newFixedThreadPool(3);
        Counter summation = new Counter();

        IntStream.range(0, 1000).forEach(count -> service.submit(summation::calculate));
        service.awaitTermination(1000, TimeUnit.MILLISECONDS);

        assertEquals(1000, summation.getSum());
    }
}