package com.sda.badAssWritersQA.badAssWritersQA.services;

import com.sda.badAssWritersQA.badAssWritersQA.model.Questionnaire;
import com.sda.badAssWritersQA.badAssWritersQA.repository.QuestionnaireRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionnaireService {

    private QuestionnaireRepository questionnaireRepository;

    public QuestionnaireService(QuestionnaireRepository questionnaireRepository){
        this.questionnaireRepository = questionnaireRepository;
    }

    public List<Questionnaire> getAllQuestionnaires(){return questionnaireRepository.findAll();}
}
