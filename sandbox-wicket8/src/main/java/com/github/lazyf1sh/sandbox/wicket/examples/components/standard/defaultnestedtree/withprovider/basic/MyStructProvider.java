package com.github.lazyf1sh.sandbox.wicket.examples.components.standard.defaultnestedtree.withprovider.basic;

import org.apache.wicket.extensions.markup.html.repeater.tree.ITreeProvider;
import org.apache.wicket.model.IModel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyStructProvider implements ITreeProvider<MyStruct>
{
    private List<MyStruct> myStructList;

    public MyStructProvider()
    {
        myStructList = DbMock.loadFromDb();
    }

    public void reload()
    {
        myStructList = DbMock.loadFromDbRemoveThisMethod();
    }

    @Override
    public Iterator<? extends MyStruct> getRoots()
    {
        return myStructList.iterator();
    }

    @Override
    public boolean hasChildren(final MyStruct node)
    {
        return node != null && !node.getSiblings().isEmpty();
    }

    @Override
    public Iterator<? extends MyStruct> getChildren(final MyStruct node)
    {
        return node.getSiblings().iterator();
    }

    @Override
    public IModel<MyStruct> model(final MyStruct object)
    {
        return new MyStructModel(object);
    }

    @Override
    public void detach()
    {
        myStructList = new ArrayList<>();
    }
}
