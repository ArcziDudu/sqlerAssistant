package com.opensql.opensql.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class GptSqlerRequest {
    private String model;
    public List<Message> messages;

    public GptSqlerRequest(String model, String prompt) {
        this.model = model;
        this.messages = new ArrayList<>();
        this.messages.add(new Message("user", "You are an assistant who creates SQL queries based on given commands. Give only sql queries, don't give any other words. If provided query is wrong then tell: Oops, your prompt is wrong! Try again" +
                "Generate a SQL query for: "+prompt));
    }
}
