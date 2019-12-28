package com.github.lazyf1sh.sandbox.java.mechanics.oop.inheritance.methodoverriding;

public class Child extends Parent
{

    public String q = "child";

    public String getValue() // overrides Parent.getValue()
    {
        return "child";
    }
}
