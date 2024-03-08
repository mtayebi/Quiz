package com.microservice.quizservice.service;


import com.microservice.quizservice.dto.Answers;
import com.microservice.quizservice.model.Quiz;

import java.util.List;


public interface QuizService {
    Quiz generate(String category, int numOfQuestions, String title);
    Quiz findById(Long id);

    String getScore(Long quizId, List<Answers> answers);
}
