package com.telusko.quizapp.dao;

import com.telusko.quizapp.model.QuizAttempt;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuizAttemptDao extends JpaRepository<QuizAttempt, Integer> {
    List<QuizAttempt> findByUsername(String username);
    long countByUsernameAndQuizTitle(String username, String quizTitle);
}