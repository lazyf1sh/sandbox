package com.github.lazyf1sh.sandbox.java.jcl.java.util.collections;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;

/**
 * The insertion, addition and removal operations of an item are faster in a LinkedList. <br/>
 * Because there is no need to resize an array or update the index.<br/>
 * Only references in surrounding elements will change.<br/>
 *
 * @see <a href="https://www.baeldung.com/java-linkedlist">https://www.baeldung.com/java-linkedlist</a>
 * @see <a href="https://stackoverflow.com/questions/393556/when-to-use-a-linked-list-over-an-array-array-list">https://stackoverflow.com/questions/393556/when-to-use-a-linked-list-over-an-array-array-list</a>
 * @see <a href="https://imgur.com/a/gmQVtBb">https://imgur.com/a/gmQVtBb</a>
 * @see <a href="https://imgur.com/a/0QEAN8O">https://imgur.com/a/0QEAN8O</a>
 */
public class LinkedListExampleTest
{
    @Test
    public void run()
    {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("b");
        linkedList.add("c");
        linkedList.add("d");
        linkedList.addFirst("a");

        Assert.assertEquals("a", linkedList.get(0));
        Assert.assertEquals("b", linkedList.get(1));
        Assert.assertEquals("c", linkedList.get(2));
        Assert.assertEquals("d", linkedList.get(3));
    }

    @Test
    public void run2()
    {
        LinkedList<String> linkedList = new LinkedList<>();

        linkedList.add(0, "a");
        linkedList.add("a");
        linkedList.add("b");
        linkedList.add("b");
        linkedList.add("c");

        boolean bRemoved = linkedList.removeLastOccurrence("b");
        Assert.assertTrue(bRemoved);

        Assert.assertEquals("a", linkedList.get(0));
        Assert.assertEquals("a", linkedList.get(1));
        Assert.assertEquals("b", linkedList.get(2));
        Assert.assertEquals("c", linkedList.get(3));
    }


    @Test
    public void run3()
    {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("a");
        linkedList.add("b");
        linkedList.add("b");
        linkedList.add("c");

        String peeked = linkedList.peek();
        Assert.assertEquals(peeked, "a");
        Assert.assertEquals(4, linkedList.size());


        String poped = linkedList.pop();

        Assert.assertEquals(poped, "a");
        Assert.assertEquals(3, linkedList.size());
    }

    @Test
    public void run4()
    {
        LinkedList<String> linkedList = new LinkedList<>();

        linkedList.add("a");
        linkedList.add("b");
        linkedList.add("c");

        linkedList.poll();

        Assert.assertEquals(2, linkedList.size());
        Assert.assertEquals("b", linkedList.get(0));
        Assert.assertEquals("c", linkedList.get(1));
    }

}
