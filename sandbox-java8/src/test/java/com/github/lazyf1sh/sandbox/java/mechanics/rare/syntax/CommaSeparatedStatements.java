package com.github.lazyf1sh.sandbox.java.mechanics.rare.syntax;

import org.junit.Assert;
import org.junit.Test;

public class CommaSeparatedStatements
{
    @Test
    public void validSyntax()
    {
        float foo = 2, bar = 3, baz = 4;//1//
        float mod1 = foo % baz, mod2 = baz % foo;  //2
        float result = mod1 > mod2 ? bar : baz; //3
//        Assert.assertEquals(, result); //calculate yourself
    }

    @Test
    public void assignmentInsideExpression()
    {
        int i1 = 1;
        int i2 = 2;
        int i3 = 3;

        int i4 = i1 + (i2 = i3);
        Assert.assertEquals(4, i4);
    }

    @Test
    public void evalInsideSwitch()
    {
        {
            char[] ca = {'a', 'b', 'c', 'd'};
            int i = 0;
            for (char c : ca)
            {
                switch (c)
                {
                    case 'a':
                        i++;
                    case 'b':
                        ++i;
                    case 'c' | 'd':
                        i++;
                }
            }
            Assert.assertEquals(5, i);
        }
    }
}
