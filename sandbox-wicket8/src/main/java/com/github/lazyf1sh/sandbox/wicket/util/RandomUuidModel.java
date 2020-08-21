package com.github.lazyf1sh.sandbox.wicket.util;

import org.apache.wicket.markup.html.form.IChoiceRenderer;
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
        throw new RuntimeException("is not supposed to be implemented for demo scenario.");
    }

    @Override
    public void detach()
    {
        System.out.println("RandomUuidModel - detach");
    }

}
