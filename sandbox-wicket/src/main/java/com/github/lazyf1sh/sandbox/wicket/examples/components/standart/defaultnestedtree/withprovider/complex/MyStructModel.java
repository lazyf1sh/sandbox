package com.github.lazyf1sh.sandbox.wicket.examples.components.standart.defaultnestedtree.withprovider.complex;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

import org.apache.wicket.model.LoadableDetachableModel;

public class MyStructModel extends LoadableDetachableModel<MyNode>
{
    private String id;

    public MyStructModel(final MyNode object)
    {
        super(object);
        this.id = object.getId();
    }

    @Override
    protected MyNode load()
    {
        List<MyNode> myStructs = Collections.singletonList(DbMock.loadFromDb());

        return DbMock.findMyStruct(myStructs, id);
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
        final MyStructModel that = (MyStructModel)o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id);
    }
}
