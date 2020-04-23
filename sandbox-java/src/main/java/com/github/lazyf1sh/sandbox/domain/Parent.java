package com.github.lazyf1sh.sandbox.domain;

import java.util.ArrayList;
import java.util.List;

public class Parent
{
    private List<Parent> list = new ArrayList<>();

    public List<Parent> getList()
    {
        return list;
    }

    public void addValue(Parent value)
    {
        list.add(value);
    }
}
