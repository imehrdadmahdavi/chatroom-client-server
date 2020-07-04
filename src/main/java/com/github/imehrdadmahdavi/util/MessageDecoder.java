package com.github.imehrdadmahdavi.util;

import java.io.StringReader;

import javax.json.Json;
import javax.json.JsonObject;
import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

import com.github.imehrdadmahdavi.model.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MessageDecoder implements Decoder.Text<Message> {
    private static final Logger logger = LoggerFactory.getLogger(MessageDecoder.class);

    @Override
    public Message decode(String jsonMessage) throws DecodeException {
        JsonObject json = Json.createReader(new StringReader(jsonMessage)).readObject();
        return new Message(json);
    }

    @Override
    public boolean willDecode(String jsonMessage) {
        try {
            Json.createReader(new StringReader(jsonMessage)).readObject();
            return true;
        } catch (Exception e) {
            logger.error(e.getMessage());
            return false;
        }
    }

    @Override
    public void init(EndpointConfig ec) {
        logger.info("init.");
    }

    @Override
    public void destroy() {
        logger.info("destroy.");
    }

}