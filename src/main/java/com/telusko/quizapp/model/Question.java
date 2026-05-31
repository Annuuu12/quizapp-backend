package com.telusko.quizapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import jakarta.persistence.Table;
import jakarta.persistence.Id;

@Data
@Entity
@Table(name = "question")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Question title cannot be empty")
    private String questionTitle;
    @NotBlank(message = "Option1 cannot be empty")
    private String option1;
    @NotBlank(message = "Option2 cannot be empty")
    private String option2;
    @NotBlank(message = "Option3 cannot be empty")
    private String option3;
    @NotBlank(message = "Option4 cannot be empty")
    private String option4;
    @NotBlank(message = "Right answer cannot be empty")
    private String rightAnswer;
    private String difficultyLevel;
    @NotBlank(message = "Category cannot be empty")
    private String category;

}
