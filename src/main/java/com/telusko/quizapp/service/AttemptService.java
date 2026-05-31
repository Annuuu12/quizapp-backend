package com.telusko.quizapp.service;

import com.telusko.quizapp.dao.QuizAttemptDao;
import com.telusko.quizapp.model.AdminAttemptResponse;
import com.telusko.quizapp.model.AttemptResponse;
import com.telusko.quizapp.model.QuizAttempt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttemptService {

    @Autowired
    private QuizAttemptDao quizAttemptDao;

    public List<AttemptResponse> getHistory(String username) {
        List<QuizAttempt> attempts = quizAttemptDao.findByUsername(username);
        return attempts.stream()
                .map(attempt -> new AttemptResponse(
                        attempt.getQuizTitle(),
                        attempt.getScore(),
                        attempt.getAttemptNumber()
                ))
                .toList();
    }

    public List<AdminAttemptResponse> getAllAttempts() {
        List<QuizAttempt> attempts = quizAttemptDao.findAll();
        return attempts.stream()
                .map(attempt -> new AdminAttemptResponse(
                        attempt.getUsername(),
                        attempt.getQuizTitle(),
                        attempt.getScore(),
                        attempt.getAttemptNumber()
                ))
                .toList();
    }

}