package com.github.lazyf1sh.sandbox.java.common.tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class MyNode
{
    private String       id;
    private MyNode       parent;
    private String       title;
    private List<MyNode> childs = new ArrayList();

    public MyNode(final String id, final String title)
    {
        this.id = id;
        this.title = title;
    }

    public MyNode(final String id, final String title, final MyNode parent)
    {
        this.id = id;
        this.parent = parent;
        this.title = title;
    }

    public String getId()
    {
        return id;
    }

    public void setId(final String id)
    {
        this.id = id;
    }

    public MyNode getParent()
    {
        return parent;
    }

    public void setParent(final MyNode parent)
    {
        this.parent = parent;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(final String title)
    {
        this.title = title;
    }

    public List<MyNode> getChilds()
    {
        return childs;
    }

    public void setChilds(final List<MyNode> childs)
    {
        this.childs = childs;
    }

    boolean hasChildren()
    {
        return childs != null && !childs.isEmpty();
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
        final MyNode myStruct = (MyNode)o;
        return id.equals(myStruct.id);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id);
    }

    public void addChild(MyNode node)
    {
        childs.add(node);
    }
}
