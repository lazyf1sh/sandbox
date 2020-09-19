package com.github.lazyf1sh.sandbox.java.mechanics.concurrency.threadYield;

import org.junit.Test;

/**
 * Examples from Eckel's book.
 *
 * @author Ivan Kopylov
 */
public class BasicThreads
{
    @Test
    public void main()
    {
        Thread t = new Thread(new LiftOff());
        t.start();
        System.out.println("Waiting for LiftOff");
    }
}
