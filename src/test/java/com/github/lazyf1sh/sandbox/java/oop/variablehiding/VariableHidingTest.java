package com.github.lazyf1sh.sandbox.java.oop.variablehiding;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VariableHidingTest
{
    @Test
    public void test()
    {
        String localVariable = new VariableHiding().getLocalVariable();

        assertEquals("instance variable", new VariableHiding().getInstanceVariableWithThis());
        assertEquals("instance variable", new VariableHiding().getInstanceVariable());
        assertEquals("method local variable", new VariableHiding().getLocalVariable());
    }

}
