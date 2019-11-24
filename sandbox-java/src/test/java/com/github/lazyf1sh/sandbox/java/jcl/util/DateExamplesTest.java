package com.github.lazyf1sh.sandbox.java.jcl.util;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Ivan Kopylov
 */
public class DateExamplesTest
{
    /**
     * Date#before method exists in JCL.
     */
    @Test
    public void run() throws InstantiationException
    {
        Date date = new Date(1561165200000L); //Saturday, June 22, 2019 4:00:00 AM GMT+03:00
        Date date2 = new Date(1529629200000L); //Friday, June 22, 2018 4:00:00 AM GMT+03:00
        Assert.assertTrue(date2.before(date));
    }
}