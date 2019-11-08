package com.github.lazyf1sh.sandbox.wicket.examples.models.staticmodel;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import com.github.lazyf1sh.sandbox.wicket.RandomStringGenerator;

/**
 * When page refreshes, data is not changed
 */
public class StaticModelExample extends WebPage
{
    private static final long serialVersionUID = -4220168511329289392L;

    @Override
    protected void onInitialize()
    {
        super.onInitialize();

        IModel<String> labelModel = Model.of(RandomStringGenerator.getNext());

        Label message = new Label("message", labelModel);
        message.setOutputMarkupId(true);
        add(message);

        AjaxLink<Void> linkButton = new AjaxLink<Void>("ajaxLinkButton")
        {
            private static final long serialVersionUID = -4909033400135111195L;

            @Override
            public void onClick(AjaxRequestTarget target)
            {
                System.out.println("button clicked");
                target.add(message);
            }
        };
        add(linkButton);
    }
}