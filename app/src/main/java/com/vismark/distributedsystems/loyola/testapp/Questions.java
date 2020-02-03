package com.vismark.distributedsystems.loyola.testapp;

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
        return "Questions{" +
                "questions=" + questions +
                '}';
    }
}
