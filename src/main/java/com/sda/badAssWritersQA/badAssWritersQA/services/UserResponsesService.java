package com.sda.badAssWritersQA.badAssWritersQA.services;

import com.sda.badAssWritersQA.badAssWritersQA.exeptions.UserResponsesNotFoundException;
import com.sda.badAssWritersQA.badAssWritersQA.model.Question;
import com.sda.badAssWritersQA.badAssWritersQA.model.UserResponses;
import com.sda.badAssWritersQA.badAssWritersQA.repository.UserResponsesRepository;
import org.hibernate.hql.internal.QueryExecutionRequestException;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.UUID;

@Service
public class UserResponsesService extends UserResponsesNotFoundException {
    private UserResponsesRepository userResponsesRepository;

    public UserResponsesService(UserResponsesRepository userResponsesRepository) {
        this.userResponsesRepository = userResponsesRepository;
    }

    public String generateUniqueId(){
        UUID uniqueId = UUID.randomUUID();
        return uniqueId.toString();
    }

    public UserResponses createNewUserResponse(UserResponses userResponse) throws UserResponsesNotFoundException{
        return userResponsesRepository.save(userResponse);
    }





}
