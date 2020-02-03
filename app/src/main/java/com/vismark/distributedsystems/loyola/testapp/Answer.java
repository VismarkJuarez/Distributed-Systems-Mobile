package com.vismark.distributedsystems.loyola.testapp;

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
}
