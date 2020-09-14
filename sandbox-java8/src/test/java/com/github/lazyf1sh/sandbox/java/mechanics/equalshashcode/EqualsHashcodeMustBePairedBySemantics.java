package com.github.lazyf1sh.sandbox.java.mechanics.equalshashcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author Ivan Kopylov
 */
public class EqualsHashcodeMustBePairedBySemantics
{
    private boolean equalsCalled   = false;
    private boolean hashcodeCalled = false;

    @Test
    public void querySet()
    {
        WronglyDefinedEqualsHashcode class1 = new WronglyDefinedEqualsHashcode("1");
        WronglyDefinedEqualsHashcode class2 = new WronglyDefinedEqualsHashcode("2");

        Set<WronglyDefinedEqualsHashcode> set = new HashSet<>();
        set.add(class1);
        set.add(class2);

        boolean containsResult = set.contains(new WronglyDefinedEqualsHashcode("2"));

        Assert.assertTrue(equalsCalled);
        Assert.assertTrue(hashcodeCalled);
        Assert.assertFalse(containsResult); //false because after finding by hashcode, equals check failed inside HashSet
    }


    class WronglyDefinedEqualsHashcode
    {
        private final String value;

        public WronglyDefinedEqualsHashcode(String value)
        {
            this.value = value;
        }

        @Override
        public boolean equals(Object o) //default implementation
        {
            equalsCalled = true;
            return super.equals(o);
        }

        @Override
        public int hashCode() //custom implementation
        {
            hashcodeCalled = true;
            return Objects.hash(value);
        }
    }
}
