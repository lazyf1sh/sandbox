package com.github.lazyf1sh.sandbox.wicket.examples.components.standart.defaultnestedtree.folderchecked;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CheckedFolderNode implements Serializable
{
    private CheckedFolderNode       parent;
    private String                  title;
    private List<CheckedFolderNode> children = new ArrayList<>();

    public CheckedFolderNode getParent()
    {
        return parent;
    }

    public void setParent(final CheckedFolderNode parent)
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

    public List<CheckedFolderNode> getChildren()
    {
        return children;
    }

    public void setChildren(final List<CheckedFolderNode> children)
    {
        this.children = children;
    }

    public boolean hasChildren()
    {
        return children != null && !children.isEmpty();
    }

    @Override
    public String toString()
    {
        return title;
    }
}
