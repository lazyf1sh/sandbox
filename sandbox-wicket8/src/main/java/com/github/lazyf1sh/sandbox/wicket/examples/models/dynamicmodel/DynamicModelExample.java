package com.github.lazyf1sh.sandbox.wicket.examples.models.dynamicmodel;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import com.github.lazyf1sh.sandbox.wicket.util.RandomStringGenerator;

/**
 * When component refreshes, data is not changed
 */
public class DynamicModelExample extends WebPage
{
    private static final long serialVersionUID = 3545275013317507348L;

    @Override
    protected void onInitialize()
    {
        super.onInitialize();

        IModel<String> model = new Model<String>()
        {
            private static final long serialVersionUID = 8438396920195371427L;

            @Override
            public String getObject()
            {
                System.out.println("LoadableDetachableModel called.");
                return RandomStringGenerator.getNext();
            }
        };

        Label message = new Label("message", model);
        message.setOutputMarkupId(true);
        add(message);

        Label message2 = new Label("message2", model);
        message2.setOutputMarkupId(true);
        add(message2);

        AjaxLink<Void> linkButton = new AjaxLink<Void>("ajaxLinkButton")
        {
            private static final long serialVersionUID = -4909033400135111195L;

            @Override
            public void onClick(AjaxRequestTarget target)
            {
                System.out.println("button clicked");
                target.add(message);
                target.add(message2);
            }
        };
        add(linkButton);
    }
}