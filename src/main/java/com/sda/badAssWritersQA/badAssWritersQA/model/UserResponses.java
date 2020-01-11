package com.sda.badAssWritersQA.badAssWritersQA.model;

import javax.persistence.*;

@Entity
public class UserResponses {
    @Id
    @GeneratedValue
    private long id;
    @ManyToOne
    private Answer answer;
    @ManyToOne
    private Question question;
    @ManyToOne
    private Questionnaire questionnaire;
    private long answerCounter;

    public UserResponses(){}

    public UserResponses(Answer answer, Question question, Questionnaire questionnaire, long answerCounter) {
        this.answer = answer;
        this.question = question;
        this.questionnaire = questionnaire;
        this.answerCounter = answerCounter;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Questionnaire getQuestionnaire() {
        return questionnaire;
    }

    public void setQuestionnaire(Questionnaire questionnaire) {
        this.questionnaire = questionnaire;
    }

    public long getAnswerCounter() {
        return answerCounter;
    }

    public void setAnswerCounter(long answerCounter) {
        this.answerCounter = answerCounter;
    }
}
