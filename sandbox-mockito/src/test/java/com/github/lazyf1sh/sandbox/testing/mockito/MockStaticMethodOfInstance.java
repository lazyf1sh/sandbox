package com.github.lazyf1sh.sandbox.testing.mockito;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MockStaticMethodOfInstance
{
    @Mock
    private MyClassToMockMethod myClassToMockMethod;

    @Test
    public void runMocked()
    {
//        Mockito.when(myClassToMockMethod.myMethod()).thenReturn("Custom value");
//        Assert.assertEquals("Custom value", myClassToMockMethod.myMethod());
    }
}
