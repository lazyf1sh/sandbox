package com.github.lazyf1sh.sandbox.patterns.singleton.singletonmockfailed;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class MyEnumLazySingletonTest
{
    @Test(expected = IllegalArgumentException.class)
    public void mockSingleton() throws IllegalAccessException, NoSuchFieldException
    {
        Field field = MyEnumSingletonImpl.class.getDeclaredField("INSTANCE");

        Field modifiersField = Field.class.getDeclaredField("modifiers");
        modifiersField.setAccessible(true);
        modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);

        field.setAccessible(true);

        // next operation is impossible, because static field instance is of type MyEnumSingletonImpl
        // and not MyEnumSingleton
        field.set(null, new MyEnumSingletonMock());
    }
}