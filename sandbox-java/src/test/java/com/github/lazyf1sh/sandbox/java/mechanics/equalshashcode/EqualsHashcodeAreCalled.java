package com.github.lazyf1sh.sandbox.java.mechanics.equalshashcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Ivan Kopylov
 */
public class EqualsHashcodeAreCalled
{
    private boolean equalsCalled   = false;
    private boolean hashcodeCalled = false;

    @Test
    public void run2()
    {
        MyClass myClass1 = new MyClass();
        MyClass myClass2 = new MyClass();

        myClass1.equals(myClass2);

        Assert.assertTrue(equalsCalled);
        Assert.assertFalse(hashcodeCalled);
    }

    class MyClass
    {
        @Override
        public boolean equals(Object o)
        {
            equalsCalled = true;
            return super.equals(o);
        }

        @Override
        public int hashCode()
        {
            hashcodeCalled = true;
            return super.hashCode();
        }
    }
}
