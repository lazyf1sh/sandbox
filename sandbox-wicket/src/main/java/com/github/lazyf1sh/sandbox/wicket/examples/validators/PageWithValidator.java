package com.github.lazyf1sh.sandbox.wicket.examples.validators;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.Model;

public class PageWithValidator extends WebPage
{
    @Override
    protected void onInitialize()
    {
        super.onInitialize();
        PanelThatNeedToBeValidated panelThatNeedToBeValidated = new PanelThatNeedToBeValidated("panelThatNeedToBeValidated", Model.of());
        //I haven't managed to do this panel validatable

        AjaxButton button = new AjaxButton("myButton", Model.of("button text"))
        {

            @Override
            protected void onSubmit(AjaxRequestTarget target, Form<?> form)
            {
                super.onSubmit(target, form);
            }

            private static final long serialVersionUID = 1L;

        };

        Form<Void> form = new Form("form");
        form.add(panelThatNeedToBeValidated);
        form.add(button);

        add(form);
    }
}
