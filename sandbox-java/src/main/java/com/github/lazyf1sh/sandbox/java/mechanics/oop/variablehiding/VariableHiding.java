package com.github.lazyf1sh.sandbox.java.mechanics.oop.variablehiding;

/**
 * @author Ivan Kopylov
 */
public class VariableHiding
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

