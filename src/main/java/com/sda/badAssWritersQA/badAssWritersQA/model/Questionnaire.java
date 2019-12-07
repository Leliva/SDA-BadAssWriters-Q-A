package com.sda.badAssWritersQA.badAssWritersQA.model;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;
import java.util.Collection;

@Entity
public class Questionnaire {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    @OneToMany
    private Collection<Question> question;

    public Questionnaire(String name) {
        this.name = name;
    }

    public Questionnaire() {

    }

    public Questionnaire(String name, Collection<Question> question) {
        this.name = name;
        this.question = question;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Question> getQuestion() {
        return question;
    }

    public void setQuestion(Collection<Question> question) {
        this.question = question;
    }
}
