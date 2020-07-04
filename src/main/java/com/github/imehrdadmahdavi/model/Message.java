package com.github.imehrdadmahdavi.model;

import java.io.StringWriter;

import javax.json.Json;
import javax.json.JsonObject;

/**
 * WebSocket message model
 */
public class Message {

    private String content;
    private String user;
    private JsonObject json;

    public Message(JsonObject json) {
        this.json = json;
    }

    public JsonObject getJson() {
        return json;
    }

    public void setJson(JsonObject json) {
        this.json = json;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Message [content=" + content + ", user=" + user + "]";
    }

    public String toJSONString() {
        StringWriter writer = new StringWriter();
        Json.createWriter(writer).write(json);
        return writer.toString();
    }
}