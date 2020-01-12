package com.sda.badAssWritersQA.badAssWritersQA.api;


import com.sda.badAssWritersQA.badAssWritersQA.exeptions.QuestionnaireNotFoundExeption;
import com.sda.badAssWritersQA.badAssWritersQA.model.Answer;
import com.sda.badAssWritersQA.badAssWritersQA.model.Question;
import com.sda.badAssWritersQA.badAssWritersQA.model.Questionnaire;
import com.sda.badAssWritersQA.badAssWritersQA.repository.QuestionRepository;
import com.sda.badAssWritersQA.badAssWritersQA.services.*;
import com.sun.org.apache.bcel.internal.generic.ARETURN;
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
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

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
        return "singleQuestionnaire";
    }

    @GetMapping("/singleQuestionnaire/conuter/{id}")
    public String counterConrolerEndpoint(@PathVariable Long id, Model model) throws QuestionnaireNotFoundExeption {

       Questionnaire questionnaire = questionnaireService.getQuestionnaireById(id);

//        for(Question q: questionnaireService.getQuestionnaireById(id).getQuestion()){
//            for (Answer a: q.getAnswers()){
//                a.getAnswerCounter();
//            }
//
//        }
        model.addAttribute("questionaire",questionnaire);
        return "results";

    }


    @PostMapping("/singleQuestionnaire/{id}")
    public String setCounterForSpecificAnswer(@Valid @ModelAttribute CollectionOfAnswers collectionOfAnswers){
        for (Answer a: collectionOfAnswers.getAnswerList()) {
            answerService.setCounter(a.getId());
        }

      return "redirect:/";
    }

    @GetMapping("/createQuestionnaire")
    public String getCreateQuestionnaireForm(Model model){
        List<Answer> answerList = new ArrayList<>();
        for(int i=0; i<2;i++){
            answerList.add(new Answer());
        }

        List<Question> questionList = new ArrayList<>();
        for(int i=0; i<2;i++){
            questionList.add(new Question());
        }
        Questionnaire questionnaire = new Questionnaire();

        for (Question q:
             questionList) {
            q.setAnswers(answerList);
        }
        questionnaire.setQuestion(questionList);

        model.addAttribute("questionnaire",questionnaire);
        model.addAttribute("form",questionnaire);
        return "createQuestionnaire";
    }

    @PostMapping("/createQuestionnaire")
    public String createQuestionnaire(@Valid @ModelAttribute Questionnaire questionnaire){

        questionnaireService.createQuestionnaire(questionnaire);

        return "redirect:/";
    }
}
