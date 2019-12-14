package com.sda.badAssWritersQA.badAssWritersQA.model;

import org.hibernate.annotations.ManyToAny;

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
    private String uniqueQuestionnaireId;

    public UserResponses(){}

    public UserResponses(Answer answer, Question question, Questionnaire questionnaire, String uniqueQuestionnaireId) {
        this.answer = answer;
        this.question = question;
        this.questionnaire = questionnaire;
        this.uniqueQuestionnaireId = uniqueQuestionnaireId;
    }



}
