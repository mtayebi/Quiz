package com.microservice.questionservice.service;

import com.microservice.questionservice.model.Question;

import java.util.List;

public interface QuestionService {

    Question addQuestion(Question question);
    Question findById(Long id) ;
    List<Question> findAll();

    Question updateQuestion(Question question);
    Question deleteQuestion(long id);

    List<Question> getQuestionByCategory(String category);
}
