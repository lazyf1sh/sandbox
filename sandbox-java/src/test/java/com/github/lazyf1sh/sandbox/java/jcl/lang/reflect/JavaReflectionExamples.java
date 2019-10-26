package com.github.lazyf1sh.sandbox.java.jcl.lang.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import org.junit.Assert;
import org.junit.Test;

import com.github.lazyf1sh.sandbox.domain.Lamp;
import com.github.lazyf1sh.sandbox.domain.Picture;
import com.github.lazyf1sh.sandbox.domain.Wall;

/**
 * Private modification via standart java reflection mechanism.
 *
 * @author Ivan Kopylov
 */
public class JavaReflectionExamples
{
    /**
     * How to modify instance field
     *
     * @throws IllegalAccessException
     * @throws NoSuchFieldException
     */
    @Test
    public void run() throws IllegalAccessException, NoSuchFieldException
    {
        Picture picture = new Picture();

        Field f1 = picture.getClass().getDeclaredField("size");
        f1.setAccessible(true);
        f1.set(picture, 500);

        Assert.assertEquals(500, picture.getSize());
    }

    @Test(expected = NoSuchFieldException.class)
    public void run2() throws NoSuchFieldException
    {
        Picture picture = new Picture();

        Field f1 = picture.getClass().getField("size");
    }

    /**
     * How to modify static field
     *
     * @throws IllegalAccessException
     * @throws NoSuchFieldException
     */
    @Test
    public void run3() throws IllegalAccessException, NoSuchFieldException
    {
        Field field = Lamp.class.getDeclaredField("color");
        field.setAccessible(true);
        field.set(null, "red");
        // modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);

        Assert.assertEquals("red", Lamp.getColor());

    }

    /**
     * How to modify final field
     *
     * @throws IllegalAccessException
     * @throws NoSuchFieldException
     */
    @Test
    public void run4() throws IllegalAccessException, NoSuchFieldException
    {
        Field field = Wall.class.getDeclaredField("kek");
        field.setAccessible(true);

        Field modifiersField = Field.class.getDeclaredField("modifiers");
        modifiersField.setAccessible(true);
        modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);

        field.set(null, "myValue");
        Assert.assertEquals("myValue", Wall.getKek());

    }

}
