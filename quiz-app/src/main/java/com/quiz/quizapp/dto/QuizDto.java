package com.quiz.quizapp.dto;

import java.util.List;

public record QuizDto(Long id, String title, List<QuestionDto> questionDtos) {
}
