package com.github.lazyf1sh.sandbox.java.jcl.time;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Ivan Kopylov
 */
public class LocalDateTimeExamples
{
    /**
     * Purpose: to show that java.util.Date differs from java.time.LocalDateTime .
     */
    @Test
    public void run()
    {
        LocalDateTime localDateTime = LocalDateTime.of(2020, 6, 15, 15, 15);
        long a = localDateTime.atZone(ZoneId.of("UTC+03:00")).toInstant().toEpochMilli();
        long b = localDateTime.atZone(ZoneId.of("UTC+02:00")).toInstant().toEpochMilli();

        Assert.assertEquals(3600000L, b - a);
        Assert.assertEquals(1592223300000L, a);
        Assert.assertEquals(1592226900000L, b);
    }

    /**
     * This example shows how to convert LocalDateTime to epoch milliseconds
     */
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

    /**
     * To show that same timezone has many aliases
     */
    @Test
    public void test2()
    {
        LocalDateTime localDateTime = LocalDateTime.of(2020, 6, 15, 15, 15);
        long a = localDateTime.atZone(ZoneId.of("Europe/Moscow")).toInstant().toEpochMilli();
        long b = localDateTime.atZone(ZoneId.of("Europe/Helsinki")).toInstant().toEpochMilli();
        long c = localDateTime.atZone(ZoneId.of("Asia/Beirut")).toInstant().toEpochMilli();
        Assert.assertEquals(a, b);
        Assert.assertEquals(a, c);
    }

    @Test
    public void test3()
    {
        LocalDateTime localDateTime = LocalDateTime.of(2020, 6, 15, 15, 15);
        long a = localDateTime.atZone(ZoneId.of("Europe/Moscow")).toInstant().toEpochMilli();
        long b = localDateTime.atZone(ZoneId.of("Africa/Cairo")).toInstant().toEpochMilli();

        Assert.assertEquals(3600000L, b - a);
    }

}
