package com.github.lazyf1sh.sandbox.java.mechanics.oop.hiding;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ClassHidesVariableTest
{
    @Test
    public void test()
    {
        String localVariable = new ClassHidesVariable().getLocalVariable();

        assertEquals("instance variable", new ClassHidesVariable().getInstanceVariableWithThis());
        assertEquals("instance variable", new ClassHidesVariable().getInstanceVariable());
        assertEquals("method local variable", new ClassHidesVariable().getLocalVariable());
    }

    /**
     * @author Ivan Kopylov
     */
    public class ClassHidesVariable
    {
        private String message = "instance variable";

        public String getLocalVariable()
        {
            String message = "method local variable";
            return message;
        }

        public String getInstanceVariableWithThis()
        {
            String message = "method local variable";
            return this.message;
        }

        public String getInstanceVariable()
        {
            return message;
        }
    }

}
