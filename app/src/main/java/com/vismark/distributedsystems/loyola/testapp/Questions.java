package com.vismark.distributedsystems.loyola.testapp;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

public class Questions {
    private List<Question> questions;

    public Questions(List<Question> questions) {
        this.questions = questions;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    @Override
    public String toString() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(this);
    }
}
