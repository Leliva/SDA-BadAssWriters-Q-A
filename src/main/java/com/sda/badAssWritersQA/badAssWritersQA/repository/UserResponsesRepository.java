package com.sda.badAssWritersQA.badAssWritersQA.repository;

import com.sda.badAssWritersQA.badAssWritersQA.model.UserResponses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserResponsesRepository extends JpaRepository<UserResponses, Long> {

}
