package com.github.lazyf1sh.sandbox.java.jcl.lang;

import org.junit.Assert;
import org.junit.Test;

public class PrintStackTraceExample
{
    @Test
    public void createDeployment()
    {
        String s = Thread.currentThread().getStackTrace().toString();
        Assert.assertTrue(s.startsWith("[Ljava.lang.StackTraceElement;@"));
    }
}
