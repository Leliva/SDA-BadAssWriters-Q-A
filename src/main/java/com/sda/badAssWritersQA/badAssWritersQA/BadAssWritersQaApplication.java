package com.sda.badAssWritersQA.badAssWritersQA;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
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

import javax.transaction.Transactional;
import javax.xml.stream.Location;
import java.time.LocalDate;
import java.util.*;

@SpringBootApplication
public class BadAssWritersQaApplication {

    public static void main(String[] args) {
        SpringApplication.run(BadAssWritersQaApplication.class, args);
    }

	@Bean
	CommandLineRunner initDatabase(AnswerRepository answerRepository,
								   QuestionRepository questionRepository,
								   QuestionnaireRepository questionnaireRepository) {
		return args -> {

			Answer answer1 = new Answer("Quentin Tarantino", true);
			Answer answer2 = new Answer("Roman Polański", false);
			Answer answer3 = new Answer("Chyba Pulp Fiction", true);
			Answer answer4 = new Answer("Na pewno Pulp Fiction", false);

			Answer answer5 = new Answer("w Afryce", true);
			Answer answer6 = new Answer("w Azji", false);
			Answer answer7 = new Answer("Rosja", true);
			Answer answer8 = new Answer("Polska", false);


			List<Answer> answers1 = Lists.newArrayList(answer1,answer2);

			List<Answer> answers2 = Lists.newArrayList(answer3,answer4);

			List<Answer> answers3 = Lists.newArrayList(answer5,answer6);

			List<Answer> answers4 = Lists.newArrayList(answer7,answer8);


			Question question1 = new Question("Najlepszy reżyser to?", answers1);
			Question question2 = new Question("Najlepszy film Tarantino to?", answers2);
			Question question3 = new Question("Na jakim kontynencie leży Angola?",answers3);
			Question question4 = new Question("Jaki kraj ma najwiekszą powierzchnię?", answers4);


			List<Question> questions1 = Lists.newArrayList(question1,question2);

			List<Question> questions2 = Lists.newArrayList(question3,question4);


			Questionnaire questionnaire1 = questionnaireRepository.save( new Questionnaire("Kinematografia", questions1));


			Questionnaire questionnaire2 = questionnaireRepository.save( new Questionnaire("Geografia", questions2));

		};
	}

}
