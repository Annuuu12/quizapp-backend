package com.telusko.quizapp.dao;

import com.telusko.quizapp.model.QuizUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<QuizUser, Integer> {

    QuizUser findByUsername(String username);

}