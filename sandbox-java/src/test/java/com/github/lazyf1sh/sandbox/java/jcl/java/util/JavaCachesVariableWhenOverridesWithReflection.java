package com.github.lazyf1sh.sandbox.java.jcl.java.util;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.function.Supplier;

/**
 * @author Ivan Kopylov
 */
public class JavaCachesVariableWhenOverridesWithReflection
{
    @Test
    public void run() throws NoSuchFieldException, IllegalAccessException
    {
        setValue(ObjectHolder.class.getDeclaredField("FINAL_STR"), "overrided");
        setValue(ObjectHolder.class.getDeclaredField("STR"), "overrided");
        setValue(ObjectHolder.class.getDeclaredField("intFinalValue"), 10000);
        setValue(ObjectHolder.class.getDeclaredField("intValue"), 10000);

        Supplier<String> supplier = () -> "overrided";
        setValue(ObjectHolder.class.getDeclaredField("SUPPLIER"), supplier);

        Assert.assertEquals("initial", ObjectHolder.getFinalStr());
        Assert.assertEquals("overrided", ObjectHolder.getSTR());
        Assert.assertEquals("overrided", ObjectHolder.getValueFromSuplier());
        Assert.assertEquals(5000, ObjectHolder.getIntFinalValue());
        Assert.assertEquals(10000, ObjectHolder.getIntValue());
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
