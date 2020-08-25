package com.github.lazyf1sh.sandbox.wicket.examples.behaviors.ajax;

import com.github.lazyf1sh.sandbox.wicket.util.Util;
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
                String callBackScript = getCallbackScript().toString();
                String callBackUrl = getCallbackUrl().toString();

                String msg = String.format("%s | callback script: %s, callbackurl: %s", "renderHead", callBackScript, callBackUrl);
                System.out.println(msg);

                super.renderHead(component, response);
                response.render(OnLoadHeaderItem.forScript(callBackScript));//try to comment it
            }
        });
    }
}
