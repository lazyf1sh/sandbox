package com.github.lazyf1sh.sandbox.wicket.examples.pages;

import com.github.lazyf1sh.sandbox.wicket.examples.models.staticmodel.StaticModelExample;
import org.apache.wicket.ajax.AjaxEventBehavior;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.form.AjaxFormComponentUpdatingBehavior;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class HelloWorldPage extends WebPage
{
    private static final long serialVersionUID = 7209213881940063981L;

    public HelloWorldPage(final PageParameters parameters)
    {
        add(new FeedbackPanel("feedback"));

        final TextField<String> username = new TextField<String>("username", Model.of("1"));
        username.add(new AjaxEventBehavior("onclick")
        {
            private static final long serialVersionUID = -7872335862420393072L;

            @Override
            protected void onEvent(AjaxRequestTarget target)
            {
                System.out.println("AjaxEventBehavior - onclick");
                target.add(username);
            }
        });
        username.setRequired(true);

        username.add(new AjaxFormComponentUpdatingBehavior("mousedown")
        {

            private static final long serialVersionUID = 7839692292638124930L;

            @Override
            protected void onUpdate(AjaxRequestTarget target)
            {
                System.out.println("AjaxFormComponentUpdatingBehavior - onUpdate");
            }
        });

        Form<?> form = new Form<Void>("userForm")
        {

            private static final long serialVersionUID = 2836887267031980316L;

            @Override
            protected void onSubmit()
            {
                final String usernameValue = username.getModelObject();

                PageParameters pageParameters = new PageParameters();
                pageParameters.add("username", usernameValue);
                pageParameters.add("SOMEPARAMETER", "SOMEVALUE");
                setResponsePage(StaticModelExample.class, pageParameters);
            }
        };

        add(form);
        form.add(username);

    }
}
