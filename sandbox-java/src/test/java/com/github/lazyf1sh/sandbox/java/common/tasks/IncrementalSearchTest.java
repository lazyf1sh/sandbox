package com.github.lazyf1sh.sandbox.java.common.tasks;

import junit.framework.TestCase;

import java.util.Optional;

public class IncrementalSearchTest extends TestCase
{
    public void testDoSearch()
    {
        MyNode element1_root = new MyNode("element1", "element1");

        MyNode element11 = new MyNode("element11", "element11", element1_root);
        MyNode element12 = new MyNode("element12", "element12", element1_root);
        MyNode element13 = new MyNode("element13", "element13", element1_root);

        element1_root.addChild(element11);
        element1_root.addChild(element12);
        element1_root.addChild(element13);

        MyNode element111 = new MyNode("element111", "element111", element11);
        MyNode element112 = new MyNode("element112", "element112", element11);
        MyNode element113 = new MyNode("element113", "element113", element11);

        element11.addChild(element111);
        element11.addChild(element112);
        element11.addChild(element113);

        MyNode element131 = new MyNode("element131", "element131", element13);
        MyNode element132 = new MyNode("element132", "element132", element13);
        MyNode element133 = new MyNode("element133", "element133", element13);

        element13.addChild(element131);
        element13.addChild(element132);
        element13.addChild(element133);

        String searchExpression = "element13";

        IncrementalSearch incrementalSearch = new IncrementalSearch();
        incrementalSearch.doSearch(element1_root, searchExpression);

        int i = 0;
        while (incrementalSearch.hasNext())
        {
            Optional<MyNode> next = incrementalSearch.getNext();
            next.ifPresent(n -> assertTrue(n.getTitle().toLowerCase().contains(searchExpression)));
            i++;
        }
        assertEquals(i, 3);
    }
}