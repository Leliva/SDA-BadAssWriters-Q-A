package com.sda.badAssWritersQA.badAssWritersQA.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class UserResponses {
    @Id
    @GeneratedValue
    private long id;
    private Answer answer;
    private Question question;
    private Questionnaire questionnaire;

    public UserResponses(){}

    public UserResponses(Answer answer, Question question, Questionnaire questionnaire) {
        this.answer = answer;
        this.question = question;
        this.questionnaire = questionnaire;
    }
}
