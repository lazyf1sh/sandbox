package com.github.lazyf1sh.sandbox.java.mechanics.equalshashcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * @author Ivan Kopylov
 */
public class EqualsHashcodeHashMap
{
    private boolean equalsCalled   = false;
    private boolean hashcodeCalled = false;

    @Test
    public void put()
    {
        MyClass myClass1 = new MyClass("1");
        MyClass myClass2 = new MyClass("2");

        Map<MyClass, String> map = new HashMap<>();
        map.put(myClass1, "1");
        map.put(myClass2, "2");

        Assert.assertFalse(equalsCalled); //it's ok, because equals doesn't call on put operation
        Assert.assertTrue(hashcodeCalled); //it's ok
    }


    @Test
    public void query()
    {
        MyClass myClass1 = new MyClass("1");
        MyClass myClass2 = new MyClass("2");

        Map<MyClass, String> map = new HashMap<>();
        map.put(myClass1, "1");
        map.put(myClass2, "2");

        String queryResult = map.get(new MyClass("2"));

        Assert.assertTrue(equalsCalled); //it's ok
        Assert.assertTrue(hashcodeCalled); //it's ok
        Assert.assertNotNull(queryResult); //it's ok
    }


    class MyClass
    {
        private String value;

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
