package com.sda.badAssWritersQA.badAssWritersQA.services;

import com.sda.badAssWritersQA.badAssWritersQA.exeptions.QuestionnaireNotFoundExeption;

public class QuestionNotFoundException extends Exception {
    public QuestionNotFoundException(String message){super(message);}
}
