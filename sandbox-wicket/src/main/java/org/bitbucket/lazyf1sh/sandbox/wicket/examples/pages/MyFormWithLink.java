package org.bitbucket.lazyf1sh.sandbox.wicket.examples.pages;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.Model;

public class MyFormWithLink extends WebPage
{
    private static final long serialVersionUID = -4348869317433578819L;

    @Override
    protected void onInitialize()
    {
        super.onInitialize();

        Form<Void> form = new Form<Void>("form");

        AjaxLink link = new AjaxLink("trigger", Model.of("link text"))
        {
            @Override
            public void onClick(AjaxRequestTarget target)
            {
                int i = 0;
            }

        };

        Label label = new Label("label", Model.of("123"));
        link.add(label);

        //        AjaxButton trigger = new AjaxButton("trigger", Model.of("button text"))
        //        {
        //
        //            @Override
        //            protected void onSubmit(AjaxRequestTarget target, Form<?> form)
        //            {
        //                super.onSubmit(target, form);
        //            }
        //
        //            private static final long serialVersionUID = 1L;
        //        };

        form.add(link);

        add(form);
    }
}
