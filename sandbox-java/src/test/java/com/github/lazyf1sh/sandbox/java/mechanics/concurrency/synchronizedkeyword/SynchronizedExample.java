package com.github.lazyf1sh.sandbox.java.mechanics.concurrency.synchronizedkeyword;

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
    public void not_synchronized() throws InterruptedException
    {
        ExecutorService service = Executors.newFixedThreadPool(3);
        Calculator calculator = new Calculator();

        IntStream.range(0, 1000).forEach(count -> service.submit(calculator::calculate));
        service.awaitTermination(1000, TimeUnit.MILLISECONDS);

        assertEquals(1000, calculator.getSum());
    }

    @Test
    public void example_synchronized() throws InterruptedException
    {
        ExecutorService service = Executors.newFixedThreadPool(3);
        CalculatorSynchronized calculator = new CalculatorSynchronized();

        IntStream.range(0, 1000).forEach(count -> service.submit(calculator::calculate));
        service.awaitTermination(1000, TimeUnit.MILLISECONDS);

        assertEquals(1000, calculator.getSum());
    }

    @Test
    public void givenMultiThread_whenBlockSync() throws InterruptedException
    {
        ExecutorService service = Executors.newFixedThreadPool(3);
        CalculatorSynchronizedBlock synchronizedBlocks = new CalculatorSynchronizedBlock();

        IntStream.range(0, 1000).forEach(count ->service.submit(synchronizedBlocks::calculate));
        service.awaitTermination(100, TimeUnit.MILLISECONDS);

        assertEquals(1000, synchronizedBlocks.getSum());
    }

}
