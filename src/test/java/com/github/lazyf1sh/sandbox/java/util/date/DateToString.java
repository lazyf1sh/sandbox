package com.github.lazyf1sh.sandbox.java.util.date;

import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

public class DateToString
{
    @Test
    public void test()
    {
        Date date = new Date(555555555555L);
        Assert.assertEquals(date.toString(), "Mon Aug 10 04:59:15 MSD 1987");
        Assert.assertEquals(date.getTime(), 555555555555L);
    }
}
