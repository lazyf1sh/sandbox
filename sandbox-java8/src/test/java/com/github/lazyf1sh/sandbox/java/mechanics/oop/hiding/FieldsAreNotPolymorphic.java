package com.github.lazyf1sh.sandbox.java.mechanics.oop.hiding;

import org.junit.Assert;
import org.junit.Test;

public class FieldsAreNotPolymorphic
{
    @Test
    public void referenceIsFather()
    {
        Father father = new Son();
        Assert.assertEquals(1, father.i);
        Assert.assertEquals(2, father.getI());
        Assert.assertEquals(10, father.j);
        Assert.assertEquals(10, father.getJ());
    }

    @Test
    public void referenceIsSon()
    {
        Son son = new Son();

        Assert.assertEquals(2, son.i);
        Assert.assertEquals(20, son.j);
        Assert.assertEquals(2, son.getI());
        Assert.assertEquals(10, son.getJ());
    }
}

class Father
{

    int i = 1;
    int j = 10;

    public int getI()
    {
        return i;
    }

    public int getJ()
    {
        return j;
    }
}

class Son extends Father
{

    int i = 2;
    int j = 20;

    @Override
    public int getI()
    {
        return i;
    }
}
