package com.github.imehrdadmahdavi.model;

import lombok.Getter;
import lombok.Setter;

import javax.json.Json;
import javax.json.JsonObject;
import java.io.StringWriter;

/**
 * WebSocket message model
 */
@Getter
@Setter
public class Message {

    private String content;
    private String user;
    private JsonObject json;

    public Message(JsonObject json) {
        this.json = json;
    }

    public String toJSONString() {
        StringWriter writer = new StringWriter();
        Json.createWriter(writer).write(json);
        return writer.toString();
    }

    @Override
    public String toString() {
        return "Message [content=" + content + ", user=" + user + "]";
    }
}