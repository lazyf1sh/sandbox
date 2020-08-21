package com.github.lazyf1sh.sandbox.wicket.examples.components.standard.defaultnestedtree.withprovider.basic;

import org.apache.wicket.model.LoadableDetachableModel;

import java.util.List;
import java.util.Objects;

public class MyStructModel extends LoadableDetachableModel<MyStruct>
{
    private String id;

    public MyStructModel(final MyStruct object)
    {
        super(object);
        this.id = object.getId();
    }

    @Override
    protected MyStruct load()
    {
        List<MyStruct> myStructs = DbMock.loadFromDbRemoveThisMethod();

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
