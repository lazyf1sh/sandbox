package com.github.lazyf1sh.sandbox.java.mechanics.equalshashcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

/**
 * @author Ivan Kopylov
 */
public class Main
{
    @Test
    public void main()
    {
        Assert.assertFalse(new Foo().equals(null));
        Assert.assertFalse(new Date().equals(null));
    }

}
