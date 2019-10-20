package com.github.lazyf1sh.sandbox.java.jcl.util.collections;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * The insertion, addition and removal operations of an item are faster in a LinkedList. <br/>
 * Because there is no need to resize an array or update the index.<br/>
 * Only references in surrounding elements will change.<br/>
 * https://www.baeldung.com/java-linkedlist
 */
public class LinkedListExampleTest
{
    @Test
    public void run()
    {
        LinkedList<String> list = new LinkedList<>();
        list.add("b");
        list.add("c");
        list.add("d");
        list.addFirst("a");

        Assert.assertEquals("a", list.get(0));
        Assert.assertEquals("b", list.get(1));
        Assert.assertEquals("c", list.get(2));
        Assert.assertEquals("d", list.get(3));
    }

    @Test
    public void run2()
    {
        LinkedList<String> list = new LinkedList<>();
        list.add("a");
        list.add("b");
        list.add("b");
        list.add("c");
        boolean c_removed = list.removeLastOccurrence("b");
        Assert.assertTrue(c_removed);

        Assert.assertEquals("a", list.get(0));
        Assert.assertEquals("b", list.get(1));
        Assert.assertEquals("c", list.get(2));
    }


    @Test(expected = NoSuchElementException.class)
    public void run3()
    {
        LinkedList<String> list = new LinkedList<>();
        list.pop();
    }

    @Test
    public void run4()
    {
        LinkedList<String> list = new LinkedList<>();

        list.add("a");
        list.add("b");
        list.add("c");

        list.poll();

        Assert.assertEquals("b", list.get(0));
        Assert.assertEquals("c", list.get(1));

    }

}