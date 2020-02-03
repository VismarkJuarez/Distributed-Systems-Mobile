package com.vismark.distributedsystems.loyola.testapp;

public class Question {
    private String questionType;
    private int questionId;
    private String question;

    private String multipleChoiceOption1;
    private String multipleChoiceOption2;
    private String multipleChoiceOption3;

    public void setQuestionType(String questionType) {
        this.questionType = questionType;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setMultipleChoiceOption1(String multipleChoiceOption1) {
        this.multipleChoiceOption1 = multipleChoiceOption1;
    }

    public void setMultipleChoiceOption2(String multipleChoiceOption2) {
        this.multipleChoiceOption2 = multipleChoiceOption2;
    }

    public void setMultipleChoiceOption3(String multipleChoiceOption3) {
        this.multipleChoiceOption3 = multipleChoiceOption3;
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

    public String getMultipleChoiceOption1() {
        return multipleChoiceOption1;
    }

    public String getMultipleChoiceOption2() {
        return multipleChoiceOption2;
    }

    public String getMultipleChoiceOption3() {
        return multipleChoiceOption3;
    }

    @Override
    public String toString() {
        return "Question{" +
                "questionType='" + questionType + '\'' +
                ", questionId=" + questionId +
                ", question='" + question + '\'' +
                ", multipleChoiceOption1='" + multipleChoiceOption1 + '\'' +
                ", multipleChoiceOption2='" + multipleChoiceOption2 + '\'' +
                ", multipleChoiceOption3='" + multipleChoiceOption3 + '\'' +
                '}';
    }

}
