package com.sda.badAssWritersQA.badAssWritersQA.services;

import com.sda.badAssWritersQA.badAssWritersQA.repository.UserResponsesRepository;

public class UserResponsesService {
    private UserResponsesRepository userResponsesRepository;

    public UserResponsesService(UserResponsesRepository userResponsesRepository) {
        this.userResponsesRepository = userResponsesRepository;
    }


}
