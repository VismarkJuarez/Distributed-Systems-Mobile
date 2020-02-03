package com.vismark.distributedsystems.loyola.testapp;

public class Answer {
    private long questionId;
    private String studentAnswer;

    public Answer(long questionId, String studentAnswer) {
        this.questionId = questionId;
        this.studentAnswer = studentAnswer;
    }

    public void setQuestionId(long questionId) {
        this.questionId = questionId;
    }

    public void setStudentAnswer(String studentAnswer) {
        this.studentAnswer = studentAnswer;
    }

    public long getQuestionId() {
        return questionId;
    }

    public String getStudentAnswer() {
        return studentAnswer;
    }
}
