package com.microservice.questionservice.service.impl;


import com.microservice.questionservice.dto.Answers;
import com.microservice.questionservice.dto.QuestionDto;
import com.microservice.questionservice.model.Question;
import com.microservice.questionservice.repository.QuestionRepository;
import com.microservice.questionservice.service.QuestionService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {
    QuestionRepository repository;

    public QuestionServiceImpl(QuestionRepository repository){
        this.repository = repository;
    }
    @Override
    public Question addQuestion(Question question) {
        repository.save(question);
        return question;
    }

    @Override
    public Question findById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public List<Question> findAll() {
        return repository.findAll();
    }


    @Override
    @Transactional
    public Question updateQuestion(Question question) {
        Question updatedQuestion = question;

        return question;
    }

    @Override
    public Question deleteQuestion(long id) {
        Question question = repository.findById(id).get();
        repository.delete(question);
        return question;
    }

    @Override
    public List<Question> getQuestionByCategory(String category) {
        return repository.findByCategory(category);
    }

    @Override
    public List<Long> getnearte(String category, int numOfQ) {
        return repository.generateQuiz(category, numOfQ);
    }

    @Override
    public List<QuestionDto> getListOfQuestions(List<Long> questionsList) {
        List<QuestionDto> questionDtos = questionsList.stream()
                .map(q -> repository.findById(q).orElseThrow())
                .map(q -> new QuestionDto(
                        q.getId(),
                        q.getQuestionTitle(),
                        q.getOption1(),
                        q.getOption2(),
                        q.getOption3(),
                        q.getOption4()
                        )
                )
                .toList();
        return questionDtos;
    }

    @Override
    public float getScore(List<Answers> answers) {
        float score = 0;
        for (Answers answer : answers){
            if (repository.findById(answer.QuestionId())
                    .orElseGet(() ->
                            new Question()).getRightAnswer().equals(answer.rightAnswer())
            )
                score++;
        }
        return score;
    }
}
