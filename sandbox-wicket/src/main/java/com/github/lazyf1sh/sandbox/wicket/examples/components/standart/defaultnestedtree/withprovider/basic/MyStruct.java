package com.github.lazyf1sh.sandbox.wicket.examples.components.standart.defaultnestedtree.withprovider.basic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class MyStruct implements Serializable
{
    private String id;
    private MyStruct parent;
    private List<MyStruct> siblings = new ArrayList<>();

    public MyStruct(final String id)
    {
        this.id = id;
    }

    public MyStruct(final MyStruct parent, String id)
    {
        this.parent = parent;
        this.id = id;
    }

    public void addChild(final MyStruct struct)
    {
        siblings.add(struct);
    }

    public String getId()
    {
        return id;
    }

    public void setId(final String id)
    {
        this.id = id;
    }

    public MyStruct getParent()
    {
        return parent;
    }

    public void setParent(final MyStruct parent)
    {
        this.parent = parent;
    }

    public List<MyStruct> getSiblings()
    {
        return Collections.unmodifiableList(siblings);
    }

    public void setSiblings(final List<MyStruct> siblings)
    {
        this.siblings = siblings;
    }

    @Override
    public String toString()
    {
        return id;
    }

    @Override
    public boolean equals(final Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (o == null || getClass() != o.getClass())
        {
            return false;
        }
        final MyStruct myStruct = (MyStruct)o;
        return id.equals(myStruct.id);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id);
    }
}
