package com.github.lazyf1sh.sandbox.wicket.examples.components.standart.form.defaultformprocessing;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxSubmitLink;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;

public class DefaultFormProcessingFalse extends WebPage
{
    @Override
    protected void onInitialize()
    {
        super.onInitialize();

        Form<?> form = new Form("form")
        {
            @Override
            protected void onSubmit()
            {
                super.onSubmit();
                //is not triggered triggered because of setDefaultFormProcessing(false)
            }

            @Override
            protected void onError()
            {
                super.onError();
                //is not triggered triggered because of setDefaultFormProcessing(false)
            }
        };

        AjaxSubmitLink cancelButton = new AjaxSubmitLink("cancelButton", form)
        {
            @Override
            protected void onSubmit(final AjaxRequestTarget target, final Form<?> form)
            {
                super.onSubmit(target, form);
                //triggered
            }
        };
        cancelButton.setDefaultFormProcessing(false);

        form.add(cancelButton);
        add(form);
    }
}
