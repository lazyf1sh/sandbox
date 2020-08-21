package com.github.lazyf1sh.sandbox.wicket.examples.pages;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.Model;

public class MyFormWithButton extends WebPage
{
    private static final long serialVersionUID = -4348869317433578819L;

    @Override
    protected void onInitialize()
    {
        super.onInitialize();

        Form<Void> form = new Form("form");

        AjaxButton trigger2 = new AjaxButton("trigger", Model.of("button text"))
        {
            @Override
            protected void onSubmit(AjaxRequestTarget target)
            {
                super.onSubmit(target);
            }
        };
        form.add(trigger2);

        add(form);
    }
}
