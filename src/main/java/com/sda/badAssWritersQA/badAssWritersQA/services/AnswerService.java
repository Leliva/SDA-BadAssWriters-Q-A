package com.sda.badAssWritersQA.badAssWritersQA.services;

import com.sda.badAssWritersQA.badAssWritersQA.model.Answer;
import com.sda.badAssWritersQA.badAssWritersQA.repository.AnswerRepository;
import org.springframework.stereotype.Service;


@Service
public class AnswerService {

    private AnswerRepository answerRepository;

    public AnswerService(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    public Answer getAnserById(Long id) throws AnswerNotFoundException {
        return answerRepository.findById(id).orElseThrow(() -> new AnswerNotFoundException("Could not found answer with id: " + id));
    }

    public Answer createNewAnswer(Answer answer) {
        return answerRepository.save(answer);
    }
}
