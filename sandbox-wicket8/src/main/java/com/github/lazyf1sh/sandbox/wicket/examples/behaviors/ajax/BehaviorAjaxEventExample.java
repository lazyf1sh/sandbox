package com.github.lazyf1sh.sandbox.wicket.examples.behaviors.ajax;

import org.apache.wicket.ajax.AjaxEventBehavior;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.WebPage;

public class BehaviorAjaxEventExample extends WebPage
{
    private static final long serialVersionUID = -5801026524059171943L;
    int i = 0;
    
    @Override
    protected void onInitialize()
    {
        super.onInitialize();

        add(new AjaxEventBehavior("mousemove")
        {
            private static final long serialVersionUID = -1052167682945799885L;

            @Override
            protected void onEvent(AjaxRequestTarget target)
            {
                System.out.println(BehaviorAjaxEventExample.this.i++);
            }
        });
    }
}
