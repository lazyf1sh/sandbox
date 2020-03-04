package com.github.lazyf1sh.sandbox.java.jcl.util;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Ivan Kopylov
 */
public class JavaCachesVariableWhenOverridesWithReflection
{
    @Test
    public void run() throws NoSuchFieldException, IllegalAccessException
    {
        setValue(StringHolder.class.getDeclaredField("FINAL_STR"), "overrided");
        setValue(StringHolder.class.getDeclaredField("STR"), "overrided");

        Assert.assertEquals("initial", StringHolder.getFinalStr());
        Assert.assertEquals("overrided", StringHolder.getSTR());
    }

    private void setValue(Field field, Object newValue) throws NoSuchFieldException, IllegalAccessException
    {
        field.setAccessible(true);
        Field modifiersField = Field.class.getDeclaredField("modifiers");
        modifiersField.setAccessible(true);
        modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);
        field.set(null, newValue);
    }
}
