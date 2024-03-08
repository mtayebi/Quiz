package com.microservice.quizservice.controller;


import com.microservice.quizservice.dto.Answers;
import com.microservice.quizservice.dto.QuestionDto;
import com.microservice.quizservice.dto.QuizDto;
import com.microservice.quizservice.mapper.QuestionToQuestionDto;
import com.microservice.quizservice.model.Quiz;
import com.microservice.quizservice.service.QuizService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {
    QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }
    @GetMapping("/{id}")
    public ResponseEntity<QuizDto> getQuiz(@PathVariable Long id){
        Quiz quiz = quizService.findById(id);
        QuizDto quizDto = new QuizDto(
                                quiz.getId(),
                                quiz.getTitle(),
                                quiz.getQuestions().stream().
                                map(q -> QuestionToQuestionDto.INSTANCE.getQuestionDto(q))
                                        .toList()
                            );

        return ResponseEntity.ok(quizDto);
    }

    @GetMapping("/generate")
    public ResponseEntity<List<QuestionDto>> generateQuiz(
            @RequestParam String category,
            @RequestParam int numOfQuestions,
            @RequestParam String title) {
        Quiz quiz = quizService.generate(category, numOfQuestions, title);
        List<QuestionDto> questionDtos = quiz.getQuestions().stream().map(q -> QuestionToQuestionDto.INSTANCE.getQuestionDto(q)).toList();
        return ResponseEntity.ok(questionDtos);
    }

    @PostMapping("/get-score/{quizId}")
    public ResponseEntity<String> getScore(@PathVariable Long quizId, @RequestBody List<Answers> answers){
        String score = quizService.getScore(quizId, answers);
        return ResponseEntity.ok("your score is: "+ score);
    }
}
