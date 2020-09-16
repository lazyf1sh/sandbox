package com.github.lazyf1sh.sandbox.java.mechanics.concurrency.exectutor;

import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.Executor;

/**
 * The default implementation.
 *
 * @author Ivan Kopylov
 */
public class ExecutorInterfaceExample
{
    @Test
    public void run()
    {
        Executor executor = new Executor()
        {
            @Override
            public void execute(Runnable runnable)
            {
                runnable.run();
            }
        };
        Assert.assertEquals("main", Thread.currentThread().getName());
        executor.execute(() -> Assert.assertEquals("main", Thread.currentThread().getName()));
    }
}
