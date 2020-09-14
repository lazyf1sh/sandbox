package com.github.lazyf1sh.sandbox.java.exercises.fixme;

import org.junit.Test;

/**
 * @author Ivan Kopylov
 */
public class whyAlwaysFive
{
    int i = 0;

    @Test
    public void recurred()
    {
        i++;
        if (i < 5)
        {
            recurred();
        }
        System.out.println(i);
    }

}
