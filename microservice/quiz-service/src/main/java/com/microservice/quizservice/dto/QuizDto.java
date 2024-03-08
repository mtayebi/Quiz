package com.microservice.quizservice.dto;

import java.util.List;

public record QuizDto(Long id, String title, List<QuestionDto> questionDtos) {
}
