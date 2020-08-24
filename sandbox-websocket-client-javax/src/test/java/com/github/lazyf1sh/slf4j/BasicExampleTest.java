package com.github.lazyf1sh.slf4j;


import com.github.lazyf1sh.sanbox.java.websocket.ChatClientEndpoint;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import javax.json.Json;
import javax.json.JsonObject;
import java.io.StringReader;
import java.net.URI;
import java.net.URISyntaxException;


public class BasicExampleTest
{

    private static final Logger LOGGER = LogManager.getLogger(BasicExampleTest.class);
    @Test
    public void main() throws InterruptedException, URISyntaxException {
        final ChatClientEndpoint clientEndPoint = new ChatClientEndpoint(new URI("wss://echo.websocket.org/"));
        clientEndPoint.addMessageHandler(new ChatClientEndpoint.MessageHandler() {
            public void handleMessage(String message) {
                JsonObject jsonObject = Json.createReader(new StringReader(message)).readObject();
                String userName = jsonObject.getString("user");
                if (!"bot".equals(userName)) {
                    clientEndPoint.sendMessage(getMessage("Hello " + userName +", How are you?"));
                    // other dirty bot logic goes here.. :)
                }
            }
        });

        while (true) {
            clientEndPoint.sendMessage(getMessage("Hi There!!"));
            Thread.sleep(30000);
        }


    }

    private static String getMessage(String message) {
        return Json.createObjectBuilder()
                .add("user", "bot")
                .add("message", message)
                .build()
                .toString();
    }
}