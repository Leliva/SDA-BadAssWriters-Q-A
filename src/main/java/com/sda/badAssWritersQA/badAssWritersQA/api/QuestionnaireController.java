package com.sda.badAssWritersQA.badAssWritersQA.api;


import com.sda.badAssWritersQA.badAssWritersQA.exeptions.QuestionnaireNotFoundExeption;
import com.sda.badAssWritersQA.badAssWritersQA.model.Answer;
import com.sda.badAssWritersQA.badAssWritersQA.model.Question;
import com.sda.badAssWritersQA.badAssWritersQA.model.Questionnaire;
import com.sda.badAssWritersQA.badAssWritersQA.repository.QuestionRepository;
import com.sda.badAssWritersQA.badAssWritersQA.services.AnswerService;
import com.sda.badAssWritersQA.badAssWritersQA.services.CollectionOfAnswers;
import com.sda.badAssWritersQA.badAssWritersQA.services.QuestionService;
import com.sda.badAssWritersQA.badAssWritersQA.services.QuestionnaireService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;

@Validated
@Controller
public class QuestionnaireController {

    private QuestionnaireService questionnaireService;
    private QuestionService questionService;
    private AnswerService answerService;



    public QuestionnaireController(QuestionnaireService questionnaireService,
                                   QuestionService questionService,
                                   AnswerService answerService){
        this.questionnaireService = questionnaireService;
        this.questionService = questionService;
        this.answerService = answerService;
    }



    @Value("questionnaires.message")
    private String message;

    @GetMapping("/")
    public String main(Model model){
        model.addAttribute("message", message);
        model.addAttribute("questionnaires",questionnaireService.getAllQuestionnaires());
        return "questionnaires";
    }

    @GetMapping("/singleQuestionnaire/{id}")
    public String mainSingleQuestionnaire(@PathVariable Long id, Model model) throws QuestionnaireNotFoundExeption {
        CollectionOfAnswers collectionOfAnswers = new CollectionOfAnswers();
        model.addAttribute("message", message);
        model.addAttribute("singleQuestionnaire",questionnaireService.getQuestionnaireById(id));

        for (Question q: questionnaireService.getQuestionnaireById(id).getQuestion()) {


                collectionOfAnswers.addAnswer(new Answer());

        }

        model.addAttribute("form",collectionOfAnswers);
        Questionnaire questionnaire1 = questionnaireService.getQuestionnaireById(id);
        return "singleQuestionnaire";
    }


    @PostMapping("/singleQuestionnaire/{id}")
    public String setCounterForSpecificAnswer(@ModelAttribute CollectionOfAnswers collectionOfAnswers){
        for (Answer a: collectionOfAnswers.getAnswerList()) {
            answerService.setCounter(a.getId());
        }

      return "redirect:/";
    }

}
