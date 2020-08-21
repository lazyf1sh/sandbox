package com.github.lazyf1sh.sandbox.wicket.examples.components.standard.ajaxlink;

import org.apache.wicket.ajax.AjaxEventBehavior;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Button;

/**
 * Purpose of this example: this is one of examples in a set of demonstrating wicket ways to call backend with various types of triggers
 */
public class ButtonExample extends WebPage
{
    @Override
    protected void onInitialize()
    {
        super.onInitialize();

        Button myButton = new Button("myButton")
        {
            private static final long serialVersionUID = 584041757386424641L;
        };

        myButton.add(new AjaxEventBehavior("click")
        {
            private static final long serialVersionUID = -6255077381652345099L;

            @Override
            protected void onEvent(AjaxRequestTarget target)
            {
                System.out.println("123");
            }
        });
        add(myButton);
    }
}
