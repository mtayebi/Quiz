package com.quiz.quizapp.controller;

import com.quiz.quizapp.dto.QuestionDto;
import com.quiz.quizapp.mapper.QuestionToQuestionDto;
import com.quiz.quizapp.model.Question;
import com.quiz.quizapp.service.QuestionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/question")
public class QuestionController {

    QuestionService questionService;

    public QuestionController(QuestionService questionService){
        this.questionService = questionService;
    }

    @GetMapping("/{id}")
    public QuestionDto getQuestionById(@PathVariable Long id){
        Question question = questionService.findById(id);
        QuestionDto questionDto = QuestionToQuestionDto.INSTANCE.getQuestionDto(question);
        return questionDto;
    }

    @GetMapping
    public List<QuestionDto> getQuestions(){
        List<Question> questionList = questionService.findAll();
        List<QuestionDto> questionDtoList = questionList.stream()
                .map(question -> QuestionToQuestionDto
                .INSTANCE.getQuestionDto(question)).collect(Collectors.toList());
        return questionDtoList;
    }

    @PostMapping("/add-question")
    public ResponseEntity<String> addQuestion(@RequestBody Question question){
        questionService.addQuestion(question);
        return ResponseEntity.ok("question has been added to the question pool successfully");
    }

}
