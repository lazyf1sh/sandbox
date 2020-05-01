package com.github.lazyf1sh.sandbox.wicket.examples.pages;

import org.apache.wicket.markup.html.form.IChoiceRenderer;

/**
 * @author Ivan Kopylov
 */
public class MyChoiceRenderer implements IChoiceRenderer<String>
{
    @Override
    public Object getDisplayValue(String object)
    {
        System.out.println(String.format("object: %s", object));
        return object + " my custom postfix";
    }

    @Override
    public String getIdValue(String object, int index)
    {
        System.out.println(String.format("index: %s, object: %s", index, object));
        return object + " my custom postfix";
    }
}
