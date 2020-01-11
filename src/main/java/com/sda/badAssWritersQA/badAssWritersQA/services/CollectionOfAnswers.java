package com.sda.badAssWritersQA.badAssWritersQA.services;

import com.sda.badAssWritersQA.badAssWritersQA.model.Answer;
import org.springframework.stereotype.Service;

import javax.persistence.OneToOne;
import java.util.ArrayList;
import java.util.List;

@Service
public class CollectionOfAnswers {
    private List<Answer> answerList = new ArrayList<>();

    public CollectionOfAnswers(){}

    public CollectionOfAnswers(List<Answer> answerList) {
        this.answerList = answerList;
    }

    public void addAnswer(Answer answer){
        this.answerList.add(answer);
    }

    public List<Answer> getAnswerList() {
        return answerList;
    }

    public void setAnswerList(List<Answer> answerList) {
        this.answerList = answerList;
    }

    @Override
    public String toString(){
        return ""+answerList;
    }
}
