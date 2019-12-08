package com.sda.badAssWritersQA.badAssWritersQA.services;

import com.sda.badAssWritersQA.badAssWritersQA.exeptions.QuestionnaireNotFoundExeption;
import com.sda.badAssWritersQA.badAssWritersQA.model.Question;
import com.sda.badAssWritersQA.badAssWritersQA.model.Questionnaire;
import com.sda.badAssWritersQA.badAssWritersQA.repository.QuestionnaireRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class QuestionnaireService {

    private QuestionnaireRepository questionnaireRepository;
    private QuestionService questionService;

    public QuestionnaireService(QuestionnaireRepository questionnaireRepository, QuestionService questionService) {
        this.questionnaireRepository = questionnaireRepository;
        this.questionService = questionService;
    }

    public List<Questionnaire> getAllQuestionnaires() {
        return questionnaireRepository.findAll();
    }

    public Questionnaire getQuestionnaireById(Long id) throws QuestionnaireNotFoundExeption {
        return questionnaireRepository.findById(id).orElseThrow(()-> new QuestionnaireNotFoundExeption("Could not find Questionnaire with id: " + id));
    }
}
