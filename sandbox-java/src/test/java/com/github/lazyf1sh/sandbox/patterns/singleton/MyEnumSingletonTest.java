package com.github.lazyf1sh.sandbox.patterns.singleton;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import org.junit.Assert;
import org.junit.Test;

public class MyEnumSingletonTest
{
    @Test
    public void run()
    {
        String result = MyEnumSingletonImpl.INSTANCE.someMethod();
        Assert.assertEquals("test", result);
    }

    @Test
    public void mockSingleton() throws IllegalAccessException, NoSuchFieldException
    {
        Field field = MyEnumSingletonImpl.class.getDeclaredField("INSTANCE");

        Field modifiersField = Field.class.getDeclaredField("modifiers");
        modifiersField.setAccessible(true);
        modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);


        field.setAccessible(true);
        field.set(null, new MyEnumSingletonMock());

        String result = MyEnumSingletonImpl.INSTANCE.someMethod();
        Assert.assertEquals("mock", result);
    }


}