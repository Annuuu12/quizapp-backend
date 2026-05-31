package com.telusko.quizapp.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class QuizAttempt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String quizTitle;
    private Integer score;
    private Integer attemptNumber;
    private LocalDateTime attemptTime;
}