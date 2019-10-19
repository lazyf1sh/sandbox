package com.github.lazyf1sh.sandbox.testing.mockito;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class VerifyExample
{
    @Test
    public void run()
    {
        MyClass myclass = Mockito.mock(MyClass.class);
        Mockito.when(myclass.getSomeValue()).thenReturn("hello world");
        Assert.assertEquals("hello world", myclass.getSomeValue());
        Mockito.verify(myclass).getSomeValue();
    }

    @Test
    public void notInvoked()
    {
        MyClass myclass = Mockito.mock(MyClass.class);
        Mockito.when(myclass.getSomeValue()).thenReturn("hello world");
        //        Assert.assertEquals("hello world", myclass.getSomeValue());
        Mockito.verify(myclass).getSomeValue();
    }

    @Test
    public void notInvokedOneTimeNotTwo()
    {
        MyClass myclass = Mockito.mock(MyClass.class);
        Mockito.when(myclass.getSomeValue()).thenReturn("hello world");
        Assert.assertEquals("hello world", myclass.getSomeValue());
        Mockito.verify(myclass, Mockito.times(2)).getSomeValue();
    }
}
