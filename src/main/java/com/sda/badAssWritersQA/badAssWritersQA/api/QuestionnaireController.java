package com.sda.badAssWritersQA.badAssWritersQA.api;


import com.sda.badAssWritersQA.badAssWritersQA.model.Question;
import com.sda.badAssWritersQA.badAssWritersQA.services.AnswerService;
import com.sda.badAssWritersQA.badAssWritersQA.services.QuestionService;
import com.sda.badAssWritersQA.badAssWritersQA.services.QuestionnaireService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;

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

    @GetMapping("/singleQuestionnaire")
    public String mainSingleQuestionnaire(Model model){
        model.addAttribute("message", message);
        model.addAttribute("singleQuestionnaire",questionService.getAllQuestions());
        model.addAttribute("singleAnswer",answerService.getAllAnswers());
        return "singleQuestionnaire";
    }



}
