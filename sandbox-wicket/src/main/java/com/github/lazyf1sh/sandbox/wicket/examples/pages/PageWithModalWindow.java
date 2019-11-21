package com.github.lazyf1sh.sandbox.wicket.examples.pages;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.Model;
import com.github.lazyf1sh.sandbox.wicket.examples.components.standart.MyModalWindow;

public class PageWithModalWindow extends WebPage
{
    private static final long          serialVersionUID = -4348869317433578819L;
    private              MyModalWindow modalWindow      = new MyModalWindow("addDrugDialog");

    @Override
    protected void onInitialize()
    {
        super.onInitialize();
        add(modalWindow);
        add(new AjaxLink("someButton", Model.of("213"))
        {
            private static final long serialVersionUID = 1L;

            @Override
            public void onClick(AjaxRequestTarget target)
            {
                modalWindow.show(target);
            }
        });

        Form<Void> form = new Form("form");

        AjaxButton trigger2 = new AjaxButton("trigger2")
        {
            @Override
            protected void onSubmit(AjaxRequestTarget target, Form<?> form)
            {
                super.onSubmit(target, form);
            }

            private static final long serialVersionUID = 1L;
        };
        form.add(trigger2);

        add(form);
    }
}
