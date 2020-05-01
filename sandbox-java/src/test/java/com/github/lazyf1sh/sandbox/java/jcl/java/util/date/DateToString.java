package com.github.lazyf1sh.sandbox.java.jcl.java.util.date;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

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
