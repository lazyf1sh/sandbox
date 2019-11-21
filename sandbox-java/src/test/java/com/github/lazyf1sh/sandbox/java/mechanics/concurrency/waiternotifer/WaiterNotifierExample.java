package com.github.lazyf1sh.sandbox.java.mechanics.concurrency.waiternotifer;

import org.junit.Test;

/**
 * https://www.journaldev.com/1037/java-thread-wait-notify-and-notifyall-example
 */
public class WaiterNotifierExample
{
    @Test
    public void run() throws InterruptedException
    {
        Message msg = new Message("process it");
        Waiter waiter = new Waiter(msg);
        new Thread(waiter, "waiter").start();

        Waiter waiter1 = new Waiter(msg);
        new Thread(waiter1, "waiter1").start();

        Notifier notifier = new Notifier(msg);
        new Thread(notifier, "notifier").start();

        Thread.sleep(5000);
        System.out.println("All the threads are started");
    }
}
