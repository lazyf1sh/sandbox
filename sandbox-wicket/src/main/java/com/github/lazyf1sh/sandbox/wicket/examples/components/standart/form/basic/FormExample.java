package com.github.lazyf1sh.sandbox.wicket.examples.components.standart.form.basic;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.Model;

public class FormExample extends WebPage
{
    @Override
    protected void onInitialize()
    {
        super.onInitialize();


        TextField textField = new TextField("myInputText", Model.of("123"));

        Form<?> form = new Form("myForm")
        {
            @Override
            protected void onSubmit()
            {
                super.onSubmit();
            }
        };
        form.add(textField);
        add(textField);
    }
}
