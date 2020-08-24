package com.github.lazyf1sh;

import com.neovisionaries.ws.client.WebSocket;
import com.neovisionaries.ws.client.WebSocketException;
import com.neovisionaries.ws.client.WebSocketFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import java.io.IOException;

public class RunnerTest {

    private static final Logger LOGGER = LogManager.getLogger(RunnerTest.class);

    @Test
    public void testMain() throws WebSocketException, IOException {


        WebSocket socket = new WebSocketFactory().createSocket("wss://echo.websocket.org");
        socket.addListener(new MyDebugWebsocketAdapter());

        socket.connect();
        socket.sendText("hi");
    }

}