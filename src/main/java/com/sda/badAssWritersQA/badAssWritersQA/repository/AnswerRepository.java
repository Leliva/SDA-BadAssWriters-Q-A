package com.sda.badAssWritersQA.badAssWritersQA.repository;

import com.sda.badAssWritersQA.badAssWritersQA.model.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AnswerRepository extends JpaRepository<Answer,Long> {
}
