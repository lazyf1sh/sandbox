package org.bitbucket.lazyf1sh.sandbox.wicket.examples.components.standart.defaultnestedtree.withprovider.complex;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.apache.wicket.extensions.markup.html.repeater.tree.ITreeProvider;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

public class MyStructProvider implements ITreeProvider<MyNode>
{
    private List<MyNode> myStructList;

    public MyStructProvider()
    {
        myStructList = Collections.singletonList(DbMock.loadFromDb());
    }

    public void reload()
    {
        myStructList = Collections.singletonList(DbMock.loadFromDb());
    }

    @Override
    public Iterator<? extends MyNode> getRoots()
    {
        return myStructList.iterator();
    }

    @Override
    public boolean hasChildren(final MyNode node)
    {
        return node != null && !node.getChilds().isEmpty();
    }

    @Override
    public Iterator<? extends MyNode> getChildren(final MyNode node)
    {
        return node.getChilds().iterator();
    }

    @Override
    public IModel<MyNode> model(final MyNode object)
    {
        return Model.of(object);
    }

    @Override
    public void detach()
    {

    }
}
