package com.loyola.distributedsystems439.spring2020.testapp.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.UUID;

public class Response {
    private String kind;
    private String type;
    private String choice;
    private UUID user_id; //TODO Revisit this -- it may be a String.
    private String nickname;

    public Response(String kind, String type, String choice, UUID user_id, String nickname) {
        this.kind = kind;
        this.type = type;
        this.choice = choice;
        this.user_id = user_id;
        this.nickname = nickname;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setChoice(String choice) {
        this.choice = choice;
    }

    public void setUser_id(UUID user_id) {
        this.user_id = user_id;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getKind() {
        return kind;
    }

    public String getType() {
        return type;
    }

    public String getChoice() {
        return choice;
    }

    public UUID getUser_id() {
        return user_id;
    }

    public String getNickname() {
        return nickname;
    }

    @Override
    public String toString() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(this);
    }
}
