package com.sda.badAssWritersQA.badAssWritersQA.repository;

import com.sda.badAssWritersQA.badAssWritersQA.model.Questionnaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionnaireRepository extends JpaRepository<Questionnaire, Long> {
}
