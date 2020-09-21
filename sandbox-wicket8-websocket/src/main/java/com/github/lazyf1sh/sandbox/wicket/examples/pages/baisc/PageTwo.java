package com.github.lazyf1sh.sandbox.wicket.examples.pages.baisc;

import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.event.IEvent;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.ws.api.WebSocketBehavior;

/**
 *
 *
 * @author Ivan Kopylov
 */
public class PageTwo extends WebPage
{
    @Override
    protected void onInitialize()
    {
        super.onInitialize();


        add(new WebSocketBehavior()
        {

        });

        AjaxLink<Void> searchButton = new AjaxLink<Void>("searchButton")
        {
            @Override
            public void onClick(AjaxRequestTarget target)
            {
                target.appendJavaScript("Wicket.WebSocket.send('messageKey:messageValue')");
            }
        };
        add(searchButton);
    }
}
