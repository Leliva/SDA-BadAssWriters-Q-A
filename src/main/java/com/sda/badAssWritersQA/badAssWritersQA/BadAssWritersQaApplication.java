package com.sda.badAssWritersQA.badAssWritersQA;

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

import javax.xml.stream.Location;
import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

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

			Answer answer1 = answerRepository.save(new Answer("odp1", true));
			Answer answer2 = answerRepository.save(new Answer("odp2", false));
			Answer answer3 = answerRepository.save(new Answer("odp3", true));
			Answer answer4 = answerRepository.save(new Answer("odp4", false));


			Set<Answer> answers1 = Sets.newHashSet(answer1,answer2);

			Set<Answer> answers2 = Sets.newHashSet(answer3,answer4);


			Question question1 = questionRepository.save(new Question("Czy 2+2 to 4?", answers1));
			Question question2 = questionRepository.save(new Question("Czy 4^2 to 16?", answers1));
			Question question3 = questionRepository.save(new Question("Czy Warszawa to wieś?",answers2));
			Question question4 = questionRepository.save(new Question("Czy Reszów to miasto wojewódzkie?", answers2));


			Set<Question> questions1 = Sets.newHashSet(question1,question2);

			Set<Question> questions2 = Sets.newHashSet(question3,question4);


			Questionnaire questionnaire1 = questionnaireRepository.save( new Questionnaire("Matematyka", questions1));


			Questionnaire questionnaire2 = questionnaireRepository.save( new Questionnaire("Geografia", questions2));

		};
	}

}
