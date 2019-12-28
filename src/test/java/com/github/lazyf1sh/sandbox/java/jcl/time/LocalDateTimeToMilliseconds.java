package com.github.lazyf1sh.sandbox.java.jcl.time;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * This example shows how to convert LocalDateTime to epoch milliseconds
 */
public class LocalDateTimeToMilliseconds
{
    @Test
    public void test()
    {
        LocalDateTime localDateTime = LocalDateTime.now();
        long a = localDateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
        long b = new Date().getTime();

        if (b - a > 5)
        {
            Assert.assertTrue(false);
        }
        Assert.assertTrue(true);
    }
}
