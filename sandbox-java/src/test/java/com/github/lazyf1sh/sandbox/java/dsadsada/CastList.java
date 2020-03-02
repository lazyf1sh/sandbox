package com.github.lazyf1sh.sandbox.java.dsadsada;

import java.util.Iterator;
import java.util.List;

import org.junit.Test;

public class ChildTestQ
{
    @Test
    public void run()
    {
        Child child = new Child();
        child.addValue(new Child());
        child.addValue(new Child());

        Iterator<Child> iterator = ((List<Child>) (List<?>) child.getList()).iterator();

    }
}