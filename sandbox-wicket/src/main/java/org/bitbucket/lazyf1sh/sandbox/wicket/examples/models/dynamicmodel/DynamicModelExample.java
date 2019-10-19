package org.bitbucket.lazyf1sh.sandbox.wicket.examples.models.dynamicmodel;

import java.io.Serializable;
import java.util.Random;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.Model;

/**
 * When page refreshes, data is not changed
 */
public class DynamicModelExample extends WebPage
{

    @Override
    protected void onInitialize()
    {
        super.onInitialize();

        final MyCustomObject myCustomObject = new MyCustomObject();
        add(new Label("message", new Model()
        {
            @Override
            public Serializable getObject()
            {
                return myCustomObject.getProperty();
            }

            @Override
            public void setObject(final Object object)
            {
                myCustomObject.setProperty((String) object);
            }
        }));
    }
}