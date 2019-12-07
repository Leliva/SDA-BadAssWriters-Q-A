package com.sda.badAssWritersQA.badAssWritersQA.services;


import com.sda.badAssWritersQA.badAssWritersQA.model.Answer;
import com.sda.badAssWritersQA.badAssWritersQA.model.Question;
import com.sda.badAssWritersQA.badAssWritersQA.repository.QuestionRepository;
import org.hibernate.hql.internal.QueryExecutionRequestException;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class QuestionService {
    private QuestionRepository questionRepository;
    private AnswerService answerService;

    public QuestionService(QuestionRepository questionRepository, AnswerService answerService) {
        this.questionRepository = questionRepository;
        this.answerService = answerService;
    }

    public Question getQuestionById(Long id) throws QuestionNotFoundException {
        return questionRepository.findById(id).orElseThrow(() -> new QuestionNotFoundException("Could not found question by id: " + id));
    }

    public Question createNewQuestion (Question question) throws QueryExecutionRequestException {
        return questionRepository.save(question);
    }
}