package com.sda.badAssWritersQA.badAssWritersQA.model;

import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Answer {
    @Id
    @GeneratedValue
    private int id;
    private String description;
    private boolean correctAnswer;

    public Answer(){

    }

    public Answer(String description, boolean correctAnswer) {
        this.description = description;
        this.correctAnswer = correctAnswer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(boolean correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
}