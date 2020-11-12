package com.github.lazyf1sh.sandbox.java.exercises;

import com.github.lazyf1sh.sandbox.domain.Child;
import org.junit.Test;

import java.util.Iterator;
import java.util.List;

/**
 * https://stackoverflow.com/questions/933447/how-do-you-cast-a-list-of-supertypes-to-a-list-of-subtypes
 */
public class CastList
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