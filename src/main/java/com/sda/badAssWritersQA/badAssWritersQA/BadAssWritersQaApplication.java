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

import javax.xml.stream.Location;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Iterator;

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

			Collection<Answer> answer = new Collection<Answer>() {
				@Override
				public int size() {
					return 0;
				}

				@Override
				public boolean isEmpty() {
					return false;
				}

				@Override
				public boolean contains(Object o) {
					return false;
				}

				@Override
				public Iterator<Answer> iterator() {
					return null;
				}

				@Override
				public Object[] toArray() {
					return new Object[0];
				}

				@Override
				public <T> T[] toArray(T[] ts) {
					return null;
				}

				@Override
				public boolean add(Answer answer) {
					return false;
				}

				@Override
				public boolean remove(Object o) {
					return false;
				}

				@Override
				public boolean containsAll(Collection<?> collection) {
					return false;
				}

				@Override
				public boolean addAll(Collection<? extends Answer> collection) {
					return false;
				}

				@Override
				public boolean removeAll(Collection<?> collection) {
					return false;
				}

				@Override
				public boolean retainAll(Collection<?> collection) {
					return false;
				}

				@Override
				public void clear() {

				}
			};
			answer.add(answer1);
			answer.add(answer2);

			Question question1 = questionRepository.save(new Question("Czy 2+2 to 4?", answer));
			Question question2 = questionRepository.save(new Question("Czy Warszawa to wieś?", answer));

			Collection<Question> questions = new Collection<Question>() {
				@Override
				public int size() {
					return 0;
				}

				@Override
				public boolean isEmpty() {
					return false;
				}

				@Override
				public boolean contains(Object o) {
					return false;
				}

				@Override
				public Iterator<Question> iterator() {
					return null;
				}

				@Override
				public Object[] toArray() {
					return new Object[0];
				}

				@Override
				public <T> T[] toArray(T[] ts) {
					return null;
				}

				@Override
				public boolean add(Question question) {
					return false;
				}

				@Override
				public boolean remove(Object o) {
					return false;
				}

				@Override
				public boolean containsAll(Collection<?> collection) {
					return false;
				}

				@Override
				public boolean addAll(Collection<? extends Question> collection) {
					return false;
				}

				@Override
				public boolean removeAll(Collection<?> collection) {
					return false;
				}

				@Override
				public boolean retainAll(Collection<?> collection) {
					return false;
				}

				@Override
				public void clear() {

				}
			};
			questions.add(question1);
			questions.add(question2);

			Questionnaire questionnaire1 = questionnaireRepository.save( new Questionnaire("Matematyka", questions));
			Questionnaire questionnaire2 = questionnaireRepository.save( new Questionnaire("Geografia", questions));

		};
	}

}
