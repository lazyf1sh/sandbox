package com.github.lazyf1sh.sandbox.domain;

public class MyNotClonableObj
{
    private String field = "value";

    public String getField()
    {
        return field;
    }

    public Object get() throws CloneNotSupportedException
    {
        return super.clone();
    }
}
