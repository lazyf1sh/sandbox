package com.github.lazyf1sh.sandbox.java.mechanics.equalshashcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author Ivan Kopylov
 */
public class EqualsHashcodeSet
{
    private boolean equalsCalled   = false;
    private boolean hashcodeCalled = false;


    @Test
    public void addToSet()
    {
        MyClass myClass1 = new MyClass("1");
        MyClass myClass2 = new MyClass("2");

        Set<MyClass> set = new HashSet<>();
        set.add(myClass1);
        set.add(myClass2);

        Assert.assertFalse(equalsCalled);
        Assert.assertTrue(hashcodeCalled);
    }

    @Test
    public void querySet()
    {
        MyClass myClass1 = new MyClass("1");
        MyClass myClass2 = new MyClass("2");

        Set<MyClass> set = new HashSet<>();
        set.add(myClass1);
        set.add(myClass2);

        boolean containsResult = set.contains(new MyClass("2"));

        Assert.assertTrue(containsResult);
        Assert.assertTrue(equalsCalled);
        Assert.assertTrue(hashcodeCalled);
    }


    class MyClass
    {
        private final String value;

        public MyClass(String value)
        {
            this.value = value;
        }

        @Override
        public boolean equals(Object o)
        {
            equalsCalled = true;
            if (this == o)
            {
                return true;
            }
            if (o == null || getClass() != o.getClass())
            {
                return false;
            }
            MyClass myClass = (MyClass) o;
            return value.equals(myClass.value);
        }

        @Override
        public int hashCode()
        {
            hashcodeCalled = true;
            return Objects.hash(value);
        }
    }
}
