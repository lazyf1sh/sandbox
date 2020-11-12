package com.github.lazyf1sh.sandbox.java.mechanics.rare.syntax;

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
}
