package com.vismark.distributedsystems.loyola.testapp;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Question {
    private String questionType;
    private int questionId;
    private String question;

    private String multipleChoiceOptionA;
    private String multipleChoiceOptionB;
    private String multipleChoiceOptionC;

    public void setQuestionType(String questionType) {
        this.questionType = questionType;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setMultipleChoiceOptionA(String multipleChoiceOptionA) {
        this.multipleChoiceOptionA = multipleChoiceOptionA;
    }

    public void setMultipleChoiceOptionB(String multipleChoiceOptionB) {
        this.multipleChoiceOptionB = multipleChoiceOptionB;
    }

    public void setMultipleChoiceOptionC(String multipleChoiceOptionC) {
        this.multipleChoiceOptionC = multipleChoiceOptionC;
    }

    public String getQuestionType() {
        return questionType;
    }

    public int getQuestionId() {
        return questionId;
    }

    public String getQuestion() {
        return question;
    }

    public String getMultipleChoiceOptionA() {
        return multipleChoiceOptionA;
    }

    public String getMultipleChoiceOptionB() {
        return multipleChoiceOptionB;
    }

    public String getMultipleChoiceOptionC() {
        return multipleChoiceOptionC;
    }

    @Override
    public String toString() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(this);
    }

}
