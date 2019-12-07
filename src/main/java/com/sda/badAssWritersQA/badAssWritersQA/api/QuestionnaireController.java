package com.sda.badAssWritersQA.badAssWritersQA.api;


import com.sda.badAssWritersQA.badAssWritersQA.model.Answer;
import com.sda.badAssWritersQA.badAssWritersQA.model.Question;
import com.sda.badAssWritersQA.badAssWritersQA.model.Questionnaire;
import com.sda.badAssWritersQA.badAssWritersQA.service.QuestionnaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Controller
public class QuestionnaireController {

    private QuestionnaireService questionnaireService;

    public QuestionnaireController(QuestionnaireService questionnaireService){this.questionnaireService = questionnaireService;}

    @GetMapping
    public ResponseEntity<List<Questionnaire>> getAllQuestionnaires(){
        return ResponseEntity.ok(questionnaireService.getAllQuestionnaires());
    }
}
