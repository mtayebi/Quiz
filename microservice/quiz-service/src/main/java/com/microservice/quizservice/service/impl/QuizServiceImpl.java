package com.microservice.quizservice.service.impl;


import com.microservice.quizservice.config.FeignQuizConfig;
import com.microservice.quizservice.dto.Answers;
import com.microservice.quizservice.model.Question;
import com.microservice.quizservice.model.Quiz;
import com.microservice.quizservice.repository.QuizRepository;
import com.microservice.quizservice.service.QuizService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class QuizServiceImpl implements QuizService {
    QuizRepository quizRepository;
    FeignQuizConfig feignQuizConfig;
    public QuizServiceImpl(QuizRepository quizRepository, FeignQuizConfig feignQuizConfig){
        this.quizRepository = quizRepository;
        this.feignQuizConfig = feignQuizConfig;
    }

    @Override
    @Transactional
    public Quiz generate(String category, int numOfQuestions, String title) {
        Quiz quiz = Quiz.builder().build();
//                .questions(questionRepository.generateQuiz(category, numOfQuestions))
//                .title(title)
//                .build();
//        quizRepository.save(quiz);
        return quiz;
    }

    @Override
    public Quiz findById(Long id) {
        return quizRepository.findById(id).orElseThrow();
    }

    @Override
    public String getScore(Long quizId, List<Answers> answers) {
        Quiz quiz = quizRepository.findById(quizId).orElseThrow();
        List<Question> questions = quiz.getQuestions();
        int score = 0;
        Map<Long, String> answersMap = new HashMap<>();
        for (Answers a : answers){
            answersMap.put(a.QuestionId(), a.rightAnswer());
        }
        for (Question question : questions){
            if (answersMap.containsKey(question.getId())){
                if (answersMap.get(question.getId()).equals(question.getRightAnswer()))
                    score++;
            }
        }
        return score+ "/" + questions.size();
    }
}
