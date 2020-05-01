package com.github.lazyf1sh.sandbox.java.jcl.java.lang.strings;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Ivan Kopylov
 */
public class StringFormat
{
    @Test
    public void main()
    {
        String s = "\u221E \u0020sometext";
        System.out.println(s);
        Assert.assertEquals("∞  sometext", s);
    }

}
