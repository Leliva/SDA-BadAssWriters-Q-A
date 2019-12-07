package com.sda.badAssWritersQA.badAssWritersQA.model;


import javax.persistence.*;
import java.util.Collection;

@Entity
public class Question {
    @Id
    @GeneratedValue
    private int id;
    private String question;
    @OneToMany
    private Collection<Answer> answers;

    public Question(){

    }

    public Question(String question, Collection<Answer> answers) {
        this.question = question;
        this.answers = answers;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Collection<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(Collection<Answer> answers) {
        this.answers = answers;
    }
}
