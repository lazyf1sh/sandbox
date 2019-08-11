package com.github.lazyf1sh.sandbox.java.oop.inheritance.methodoverriding;

public class Child extends Parent
{
    public String getValue() // overrides Parent.getValue()
    {
        return "child";
    }
}
