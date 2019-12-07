package com.sda.badAssWritersQA.badAssWritersQA.services;

public class QuestionNotFoundException extends Exception {
    public QuestionNotFoundException() {
    }

    public QuestionNotFoundException(String message) {
        super(message);
    }
}