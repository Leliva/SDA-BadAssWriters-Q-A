package com.sda.badAssWritersQA.badAssWritersQA;

import com.sda.badAssWritersQA.badAssWritersQA.model.Answer;
import com.sda.badAssWritersQA.badAssWritersQA.model.Question;
import com.sda.badAssWritersQA.badAssWritersQA.model.Questionnaire;
import com.sda.badAssWritersQA.badAssWritersQA.repository.AnswerRepository;
import com.sda.badAssWritersQA.badAssWritersQA.repository.QuestionRepository;
import com.sda.badAssWritersQA.badAssWritersQA.repository.QuestionnaireRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SpringBootApplication
public class BadAssWritersQaApplication {

	public static void main(String[] args) {
		SpringApplication.run(BadAssWritersQaApplication.class, args);
	}


	@Bean
	CommandLineRunner initDatabase(QuestionnaireRepository questionnaireRepository,
								   QuestionRepository questionRepository,
								   AnswerRepository answerRepository){
		return args ->{

			Answer answer1 = answerRepository.save(new Answer("Nie",false));
			Answer answer2 = answerRepository.save(new Answer("Tak",true));

			List<Answer> answers = new ArrayList<>();

			answers.add(answer1);
			answers.add(answer2);

			Question question1 = questionRepository.save(
					new Question("Czy Szymon jest fajny",answers));

			List<Question> questions = new ArrayList<>();

			questions.add(question1);

			Questionnaire questionnaire1 = questionnaireRepository.save(new Questionnaire("Questionaire 1", questions));

		};
	}

}
