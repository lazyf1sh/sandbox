package com.github.lazyf1sh.sandbox.wicket.util;

import org.apache.wicket.model.IModel;

import java.util.UUID;

/**
 * @author Ivan Kopylov
 */
public class RandomUuidModel implements IModel<String>
{

    @Override
    public String getObject()
    {
        return UUID.randomUUID().toString();
    }

    @Override
    public void setObject(String object)
    {

    }

    @Override
    public void detach()
    {

    }
}
