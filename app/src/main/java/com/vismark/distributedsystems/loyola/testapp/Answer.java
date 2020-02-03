package com.vismark.distributedsystems.loyola.testapp;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Answer {
    private int questionId;
    private String studentAnswer;

    public Answer(int questionId, String studentAnswer) {
        this.questionId = questionId;
        this.studentAnswer = studentAnswer;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public void setStudentAnswer(String studentAnswer) {
        this.studentAnswer = studentAnswer;
    }

    public int getQuestionId() {
        return questionId;
    }

    public String getStudentAnswer() {
        return studentAnswer;
    }

    @Override
    public String toString() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(this);
    }
}
