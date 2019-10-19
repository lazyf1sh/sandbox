package org.bitbucket.lazyf1sh.sandbox.wicket.examples.components.standart.defaultnestedtree.withprovider.complex;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MyNode implements Serializable
{
    private static final long serialVersionUID = 9064729471628113857L;

    private String       id;
    private MyNode       parent;
    private boolean      isLeaf;
    private String       title;
    private List<MyNode> childs = new ArrayList<>();

    MyNode(final String id, final String title)
    {
        this.id = id;
        this.title = title;
    }

    MyNode(final String id, final String title, final MyNode parent)
    {
        this.id = id;
        this.parent = parent;
        this.title = title;
    }

    MyNode(final String id, final String title, final boolean isLeaf)
    {
        this.id = id;
        this.title = title;
        this.isLeaf = isLeaf;
    }

    void addChild(final MyNode struct)
    {
        childs.add(struct);
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

    public boolean isLeaf()
    {
        return isLeaf;
    }

    public void setLeaf(final boolean leaf)
    {
        isLeaf = leaf;
    }

    boolean hasChildren()
    {
        return childs != null && !childs.isEmpty();
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

    @Override
    public String toString()
    {
        return title;
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
}
