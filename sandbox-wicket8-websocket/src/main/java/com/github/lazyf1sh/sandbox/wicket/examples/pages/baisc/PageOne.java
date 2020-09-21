package com.github.lazyf1sh.sandbox.wicket.examples.pages.baisc;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.protocol.ws.api.WebSocketBehavior;
import org.apache.wicket.protocol.ws.api.WebSocketRequestHandler;
import org.apache.wicket.protocol.ws.api.message.TextMessage;

/**
 * @author Ivan Kopylov
 */
public class PageOne extends WebPage
{
    @Override
    protected void onInitialize()
    {
        super.onInitialize();

        Label label = new Label("label", "");
        label.setOutputMarkupId(true);
        add(label);

        add(new WebSocketBehavior()
        {
            @Override
            protected void onMessage(WebSocketRequestHandler handler, TextMessage message)
            {
                super.onMessage(handler, message);
                if (message.getText().startsWith("messageKey:"))
                {
                    label.setDefaultModelObject(message.getText());
                    handler.add(label);
                }
            }
        });
    }
}
