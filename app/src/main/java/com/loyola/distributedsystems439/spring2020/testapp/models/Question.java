package com.loyola.distributedsystems439.spring2020.testapp.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;
import java.util.UUID;

public class Question {
    private String kind; //should always be `question`
    private UUID object_id; //a unique question identifier -- TODO: Revisit, this may actually be a String
    private String type; //specifies what type of question this is (multiple_choice, short answer, etc)
    private String prompt; //the actual question prompt
    private List<String> choices; //the possible answers (only applicable if this is a multiple_choice question)
    private String answer; //the answer to the prompt -- as specified by the instructor
    private List<Response> responses; //all student responses

    public Question(String kind, UUID object_id, String type, String prompt, List<String> choices, String answer, List<Response> responses) {
        this.kind = kind;
        this.object_id = object_id;
        this.type = type;
        this.prompt = prompt;
        this.choices = choices;
        this.answer = answer;
        this.responses = responses;
    }

    public String getKind() {
        return kind;
    }

    public UUID getObject_id() {
        return object_id;
    }

    public String getType() {
        return type;
    }

    public String getPrompt() {
        return prompt;
    }

    public List<String> getChoices() {
        return choices;
    }

    public String getAnswer() {
        return answer;
    }

    public List<Response> getResponses() {
        return responses;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public void setObject_id(UUID object_id) {
        this.object_id = object_id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    public void setChoices(List<String> choices) {
        this.choices = choices;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public void setResponses(List<Response> responses) {
        this.responses = responses;
    }

    @Override
    public String toString() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(this);
    }
}
