package com.github.lazyf1sh.sandbox.java.mechanics.oop.methodhiding;

public class Child extends Parent
{
    public static String getValue() // hides Parent.getValue()
    {
        return "child";
    }
}
