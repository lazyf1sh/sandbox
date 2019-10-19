package org.bitbucket.lazyf1sh.sandbox.wicket.examples.models.staticmodel;

import java.util.Random;

import org.apache.wicket.markup.html.WebPage;

public class MyCustomObject extends WebPage
{
    private String property;

    public String getProperty()
    {
        return String.valueOf(new Random().nextInt(5000));
    }

    public void setProperty(final String property)
    {
        this.property = property;
    }
}