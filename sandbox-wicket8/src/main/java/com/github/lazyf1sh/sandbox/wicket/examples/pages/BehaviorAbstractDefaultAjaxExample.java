package com.github.lazyf1sh.sandbox.wicket.examples.pages;

import org.apache.wicket.Component;
import org.apache.wicket.ajax.AbstractDefaultAjaxBehavior;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.OnLoadHeaderItem;
import org.apache.wicket.markup.html.WebPage;

public class BehaviorAbstractDefaultAjaxExample extends WebPage
{

    private static final long serialVersionUID = 7352203927463159738L;

    @Override
    protected void onInitialize()
    {
        super.onInitialize();
        
        add(new AbstractDefaultAjaxBehavior()
        {
            private static final long serialVersionUID = -7194864693972841194L;

            @Override
            protected void respond(AjaxRequestTarget target)
            {
                System.out.println("respond");
            }

            @Override
            public void renderHead(Component component, IHeaderResponse response)
            {
                super.renderHead(component, response);
                System.out.println("renderHead");
                
                String s = getCallbackScript().toString();
                response.render(OnLoadHeaderItem.forScript(s));
            }
        });
    }
}
