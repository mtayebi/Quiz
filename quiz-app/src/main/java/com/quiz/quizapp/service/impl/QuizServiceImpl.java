package com.quiz.quizapp.service.impl;

import com.quiz.quizapp.dto.Answers;
import com.quiz.quizapp.model.Question;
import com.quiz.quizapp.model.Quiz;
import com.quiz.quizapp.repository.QuestionRepository;
import com.quiz.quizapp.repository.QuizRepository;
import com.quiz.quizapp.service.QuestionService;
import com.quiz.quizapp.service.QuizService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class QuizServiceImpl implements QuizService {
    QuizRepository quizRepository;
    QuestionRepository questionRepository;
    public QuizServiceImpl(QuizRepository quizRepository, QuestionRepository questionRepository){
        this.quizRepository = quizRepository;
        this.questionRepository = questionRepository;
    }

    @Override
    @Transactional
    public Quiz generate(String category, int numOfQuestions, String title) {
        Quiz quiz = Quiz.builder()
                .questions(questionRepository.generateQuiz(category, numOfQuestions))
                .title(title)
                .build();
        quizRepository.save(quiz);
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
