package org.bitbucket.lazyf1sh.sandbox.wicket.examples.models.staticmodel;

import java.util.Random;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.bitbucket.lazyf1sh.sandbox.wicket.examples.models.staticmodel.MyCustomObject;
/**
 * When page refreshes, data is not changed
 */
public class StaticModelExample extends WebPage
{
    @Override
    protected void onInitialize()
    {
        super.onInitialize();

        MyCustomObject myCustomObject = new MyCustomObject();
        add(new Label("message", myCustomObject.getProperty()));
    }
}