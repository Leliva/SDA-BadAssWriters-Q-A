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

    public UserResponses(){}

    public UserResponses(Answer answer, Question question, Questionnaire questionnaire) {
        this.answer = answer;
        this.question = question;
        this.questionnaire = questionnaire;
    }
}
