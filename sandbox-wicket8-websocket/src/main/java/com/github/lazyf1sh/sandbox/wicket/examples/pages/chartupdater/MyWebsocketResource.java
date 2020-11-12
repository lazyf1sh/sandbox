package com.github.lazyf1sh.sandbox.wicket.examples.pages.chartupdater;

import org.apache.wicket.Application;
import org.apache.wicket.protocol.ws.WebSocketSettings;
import org.apache.wicket.protocol.ws.api.IWebSocketConnection;
import org.apache.wicket.protocol.ws.api.WebSocketPushBroadcaster;
import org.apache.wicket.protocol.ws.api.WebSocketRequestHandler;
import org.apache.wicket.protocol.ws.api.WebSocketResource;
import org.apache.wicket.protocol.ws.api.message.ConnectedMessage;
import org.apache.wicket.protocol.ws.api.message.IWebSocketPushMessage;
import org.apache.wicket.protocol.ws.api.message.TextMessage;
import org.apache.wicket.protocol.ws.api.registry.IWebSocketConnectionRegistry;

import java.io.IOException;

/**
 *
 *
 * @author Ivan Kopylov
 */
public class MyWebsocketResource extends WebSocketResource
{
    @Override
    protected void onConnect(ConnectedMessage message)
    {
        super.onConnect(message);

        try
        {
            Application application = message.getApplication();
            WebSocketSettings webSocketSettings = WebSocketSettings.Holder.get(application);
            IWebSocketConnectionRegistry webSocketConnectionRegistry = webSocketSettings.getConnectionRegistry();
            IWebSocketConnection connection = webSocketConnectionRegistry.getConnection(application, message.getSessionId(), message.getKey());
            connection.sendMessage("asd");
//            final WebSocketPushBroadcaster broadcaster = new WebSocketPushBroadcaster(webSocketSettings.getConnectionRegistry());
//            broadcaster.broadcast(message, new IWebSocketPushMessage()
//            {
//            });
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    protected void onMessage(WebSocketRequestHandler handler, TextMessage message)
    {
        super.onMessage(handler, message);
    }
}
