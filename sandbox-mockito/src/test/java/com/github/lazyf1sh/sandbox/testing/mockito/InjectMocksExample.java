package com.github.lazyf1sh.sandbox.testing.mockito;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class InjectMocksExample
{
    @Mock
    private MyClass myClass;

    @InjectMocks
    private MyClass3 myClass3;

    @Test
    public void runMocked()
    {
        Mockito.when(myClass.getSomeValue()).thenReturn("Hello world");
        Assert.assertEquals("Hello world", myClass3.getValue());
    }

}
