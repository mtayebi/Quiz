package com.quiz.quizapp.service;

import com.quiz.quizapp.dto.Answers;
import com.quiz.quizapp.model.Quiz;
import org.springframework.stereotype.Service;

import java.util.List;


public interface QuizService {
    Quiz generate(String category, int numOfQuestions, String title);
    Quiz findById(Long id);

    String getScore(Long quizId, List<Answers> answers);
}
