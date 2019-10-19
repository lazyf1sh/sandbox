package org.bitbucket.lazyf1sh.sandbox.wicket.examples.components.standart.buttonslinks.ajaxlink;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.model.Model;

/**
 * Purpose of this example: this is one of examples in a set of demonstrating wicket ways to call backend with various types of triggers
 */
public class AjaxLinkExample extends WebPage
{
    @Override
    protected void onInitialize()
    {
        super.onInitialize();

        AjaxLink<Void> link = new AjaxLink("ajaxLink")
        {
            @Override
            public void onClick(AjaxRequestTarget target)
            {
                System.out.println("My link onclick");
            }
        };

        AjaxLink<Void> linkButton = new AjaxLink("ajaxLinkButton")
        {
            @Override
            public void onClick(AjaxRequestTarget target)
            {
                System.out.println("My linkButton onClick");
            }
        };

        AjaxLink<Void> divAjaxLink = new AjaxLink("divAjaxLink")
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
