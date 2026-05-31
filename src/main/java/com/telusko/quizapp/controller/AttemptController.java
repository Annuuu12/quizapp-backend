package com.telusko.quizapp.controller;

import com.telusko.quizapp.model.AdminAttemptResponse;
import com.telusko.quizapp.model.AttemptResponse;
import com.telusko.quizapp.model.QuizAttempt;
import com.telusko.quizapp.service.AttemptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.List;

@RestController
@RequestMapping("/attempts")
public class AttemptController {

    @Autowired
    private AttemptService attemptService;

    @GetMapping("/my-history")
    public List<AttemptResponse> getMyHistory() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        return attemptService.getHistory(username);
    }

    @GetMapping("/all")
    public List<AdminAttemptResponse> getAllAttempts() {
        return attemptService.getAllAttempts();
    }
}