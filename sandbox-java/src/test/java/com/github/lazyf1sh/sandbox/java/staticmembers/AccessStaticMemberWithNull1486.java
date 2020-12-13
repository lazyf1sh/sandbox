package com.github.lazyf1sh.sandbox.java.staticmembers;

import org.junit.Assert;
import org.junit.Test;

public class AccessStaticMemberWithNull1486
{
    /**
     * null reference is prohibited be used to access static members without an exception.
     */
    @Test
    public void run()
    {
        MyClass myClass = new MyClass();
        myClass = null;
        System.out.println();

        Assert.assertEquals("some value", myClass.VALUE);
        Assert.assertEquals("some text", myClass.myMethod());
    }
}
