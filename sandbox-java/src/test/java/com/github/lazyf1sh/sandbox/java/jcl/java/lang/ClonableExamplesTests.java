package com.github.lazyf1sh.sandbox.java.jcl.java.lang;

import com.github.lazyf1sh.sandbox.domain.MyClonableObj;
import com.github.lazyf1sh.sandbox.domain.MyNotClonableObj;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

public class ClonableExamplesTests
{
    @Test(expected = CloneNotSupportedException.class)
    public void not_clonable() throws CloneNotSupportedException
    {
        MyNotClonableObj original = new MyNotClonableObj();
        original.get();
    }

    @Test
    public void clonable() throws CloneNotSupportedException
    {
        MyClonableObj original = new MyClonableObj();

        MyClonableObj cloned = (MyClonableObj) original.get();
        assertNotSame(original, cloned);
        assertEquals(cloned.getField(), original.getField());
    }
}
