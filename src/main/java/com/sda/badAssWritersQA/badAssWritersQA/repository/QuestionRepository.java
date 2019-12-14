package com.sda.badAssWritersQA.badAssWritersQA.repository;

import com.sda.badAssWritersQA.badAssWritersQA.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question,Long> {
}
