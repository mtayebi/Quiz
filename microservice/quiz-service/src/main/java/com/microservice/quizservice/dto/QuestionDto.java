package com.microservice.quizservice.dto;

public record QuestionDto(Long id, String question, String option1, String option2, String option3, String option4) {
}
