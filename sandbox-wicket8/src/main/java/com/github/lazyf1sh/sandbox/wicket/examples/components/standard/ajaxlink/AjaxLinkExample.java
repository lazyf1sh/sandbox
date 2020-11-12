package com.github.lazyf1sh.sandbox.wicket.examples.components.standard.ajaxlink;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.WebPage;

/**
 * Purpose of this example: this is one of examples in a set of demonstrating wicket ways to call backend with various types of triggers
 */
public class AjaxLinkExample extends WebPage
{
    @Override
    protected void onInitialize()
    {
        super.onInitialize();

        AjaxLink<Void> link = new AjaxLink<Void>("ajaxLink")
        {
            private static final long serialVersionUID = -3445086817091447502L;

            @Override
            public void onClick(AjaxRequestTarget target)
            {
                System.out.println("My link onclick");
            }
        };

        AjaxLink<?> linkButton = new AjaxLink<Void>("ajaxLinkButton")
        {
            @Override
            public void onClick(AjaxRequestTarget target)
            {
                System.out.println("My linkButton onClick");
            }
        };

        AjaxLink<?> divAjaxLink = new AjaxLink<Void>("divAjaxLink")
        {
            @Override
            public void onClick(AjaxRequestTarget target)
            {
                System.out.println("My divAjaxLink onClick");
            }
        };

        add(link, linkButton, divAjaxLink);
    }
}
