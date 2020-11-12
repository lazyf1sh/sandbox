package com.github.lazyf1sh.sandbox.java.mechanics.concurrency.exectutor;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 *
 * @author Ivan Kopylov
 */
public class ExecutorServiceExample
{

    @Test
    public void newFixedThreadPool()
    {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        executor.submit(() -> System.out.println(Thread.currentThread().getName()));
    }
}
