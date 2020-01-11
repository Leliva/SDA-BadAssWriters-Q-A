package com.sda.badAssWritersQA.badAssWritersQA.services;

import com.sda.badAssWritersQA.badAssWritersQA.model.UserResponses;
import com.sda.badAssWritersQA.badAssWritersQA.repository.AnswerRepository;
import com.sda.badAssWritersQA.badAssWritersQA.repository.UserResponsesRepository;

public class UserResponsesService {

    private UserResponsesRepository userResponsesRepository;
    private AnswerRepository answerRepository;


    public UserResponsesService(UserResponsesRepository userResponsesRepository) {
        this.userResponsesRepository = userResponsesRepository;
    }

}
