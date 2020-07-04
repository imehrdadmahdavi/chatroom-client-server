package com.github.imehrdadmahdavi.util;

import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

import com.github.imehrdadmahdavi.model.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MessageEncoder implements Encoder.Text<Message> {
    private static final Logger logger = LoggerFactory.getLogger(MessageEncoder.class);

    @Override
    public String encode(Message message) throws EncodeException {

        return message.getJson().toString();

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