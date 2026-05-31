package com.telusko.quizapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AdminAttemptResponse {

    private String username;
    private String quizTitle;
    private Integer score;
    private Integer attemptNumber;
}