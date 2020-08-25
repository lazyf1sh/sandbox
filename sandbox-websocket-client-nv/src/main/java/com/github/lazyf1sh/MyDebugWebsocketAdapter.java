package com.github.lazyf1sh;

import com.neovisionaries.ws.client.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Map;

public class MyDebugWebsocketAdapter extends WebSocketAdapter {
    private static Logger LOGGER = LogManager.getLogger(MyDebugWebsocketAdapter.class);

    @Override
    public void onTextMessage(WebSocket websocket, String message) throws Exception {
        LOGGER.info("onTextMessage: {}", message);
    }

    @Override
    public void onStateChanged(WebSocket websocket, WebSocketState newState) throws Exception {
        LOGGER.info("onStateChanged. New state: {}", newState);
        super.onStateChanged(websocket, newState);
    }

    @Override
    public void onConnected(WebSocket websocket, Map<String, List<String>> headers) throws Exception {
        LOGGER.info("onConnected {}", headers);
        super.onConnected(websocket, headers);
    }

    @Override
    public void onConnectError(WebSocket websocket, WebSocketException exception) throws Exception {
        LOGGER.info("onConnectError", exception);
        super.onConnectError(websocket, exception);
    }

    @Override
    public void onDisconnected(WebSocket websocket, WebSocketFrame serverCloseFrame, WebSocketFrame clientCloseFrame, boolean closedByServer) throws Exception {
        LOGGER.info("onDisconnected");
        super.onDisconnected(websocket, serverCloseFrame, clientCloseFrame, closedByServer);
    }

    @Override
    public void onFrame(WebSocket websocket, WebSocketFrame frame) throws Exception {
        LOGGER.info("onFrame. Payload text: {}", frame.getPayloadText());
        super.onFrame(websocket, frame);
    }

    @Override
    public void onContinuationFrame(WebSocket websocket, WebSocketFrame frame) throws Exception {
        LOGGER.info("onContinuationFrame");
        super.onContinuationFrame(websocket, frame);
    }

    @Override
    public void onTextFrame(WebSocket websocket, WebSocketFrame frame) throws Exception {
//                LOGGER.info("onTextFrame. Payload text: {}", frame.getPayloadText());
        super.onTextFrame(websocket, frame);
    }

    @Override
    public void onBinaryFrame(WebSocket websocket, WebSocketFrame frame) throws Exception {
        LOGGER.info("onBinaryFrame");
        super.onBinaryFrame(websocket, frame);
    }

    @Override
    public void onCloseFrame(WebSocket websocket, WebSocketFrame frame) throws Exception {
        LOGGER.info("onCloseFrame");
        super.onCloseFrame(websocket, frame);
    }

    @Override
    public void onPingFrame(WebSocket websocket, WebSocketFrame frame) throws Exception {
        LOGGER.info("onPingFrame. Payload text: {}", frame.getPayloadText());
        super.onPingFrame(websocket, frame);
    }

    @Override
    public void onPongFrame(WebSocket websocket, WebSocketFrame frame) throws Exception {
        LOGGER.info("onPongFrame. Payload text: {}", frame.getPayloadText());
        super.onPongFrame(websocket, frame);
    }

    @Override
    public void onTextMessage(WebSocket websocket, byte[] data) throws Exception {
        LOGGER.info("onTextMessage");
        super.onTextMessage(websocket, data);
    }

    @Override
    public void onBinaryMessage(WebSocket websocket, byte[] binary) throws Exception {
        LOGGER.info("onBinaryMessage");
        super.onBinaryMessage(websocket, binary);
    }

    @Override
    public void onSendingFrame(WebSocket websocket, WebSocketFrame frame) throws Exception {
        LOGGER.info("onSendingFrame. Payload text: {}", frame.getPayloadText());
        super.onSendingFrame(websocket, frame);
    }

    @Override
    public void onFrameSent(WebSocket websocket, WebSocketFrame frame) throws Exception {
        LOGGER.info("onFrameSent. Payload text: {}", frame.getPayloadText());
        super.onFrameSent(websocket, frame);
    }

    @Override
    public void onFrameUnsent(WebSocket websocket, WebSocketFrame frame) throws Exception {
        LOGGER.info("onFrameUnsent");
        super.onFrameUnsent(websocket, frame);
    }

    @Override
    public void onError(WebSocket websocket, WebSocketException cause) throws Exception {
        LOGGER.info("onError");
        super.onError(websocket, cause);
    }

    @Override
    public void onFrameError(WebSocket websocket, WebSocketException cause, WebSocketFrame frame) throws Exception {
        LOGGER.info("onFrameError");
        super.onFrameError(websocket, cause, frame);
    }

    @Override
    public void onMessageError(WebSocket websocket, WebSocketException cause, List<WebSocketFrame> frames) throws Exception {
        LOGGER.info("onMessageError");
        super.onMessageError(websocket, cause, frames);
    }

    @Override
    public void onMessageDecompressionError(WebSocket websocket, WebSocketException cause, byte[] compressed) throws Exception {
        LOGGER.info("onMessageDecompressionError");
        super.onMessageDecompressionError(websocket, cause, compressed);
    }

    @Override
    public void onTextMessageError(WebSocket websocket, WebSocketException cause, byte[] data) throws Exception {
        LOGGER.info("onTextMessageError");
        super.onTextMessageError(websocket, cause, data);
    }

    @Override
    public void onSendError(WebSocket websocket, WebSocketException cause, WebSocketFrame frame) throws Exception {
        LOGGER.info("onSendError");
        super.onSendError(websocket, cause, frame);
    }

    @Override
    public void onUnexpectedError(WebSocket websocket, WebSocketException cause) throws Exception {
        LOGGER.info("onUnexpectedError");
        super.onUnexpectedError(websocket, cause);
    }

    @Override
    public void handleCallbackError(WebSocket websocket, Throwable cause) throws Exception {
        LOGGER.info("handleCallbackError");
        super.handleCallbackError(websocket, cause);
    }

    @Override
    public void onSendingHandshake(WebSocket websocket, String requestLine, List<String[]> headers) throws Exception {
        LOGGER.info("onSendingHandshake. Headers: {}", headers);
        super.onSendingHandshake(websocket, requestLine, headers);
    }

    @Override
    public void onThreadCreated(WebSocket websocket, ThreadType threadType, Thread thread) throws Exception {
        LOGGER.info("onThreadCreated. Thread type: {}", threadType);
        super.onThreadCreated(websocket, threadType, thread);
    }

    @Override
    public void onThreadStarted(WebSocket websocket, ThreadType threadType, Thread thread) throws Exception {
        LOGGER.info("onThreadStarted. ThreadType: {}", threadType);
        super.onThreadStarted(websocket, threadType, thread);
    }

    @Override
    public void onThreadStopping(WebSocket websocket, ThreadType threadType, Thread thread) throws Exception {
        LOGGER.info("onThreadStopping");
        super.onThreadStopping(websocket, threadType, thread);
    }
}
