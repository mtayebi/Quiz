package com.microservice.questionservice.controller;

import com.microservice.questionservice.dto.QuestionDto;
import com.microservice.questionservice.mapper.QuestionToQuestionDto;

import com.microservice.questionservice.model.Question;
import com.microservice.questionservice.service.QuestionService;
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

    @GetMapping("/category/{category}")
    public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String category){
       List<Question> questions = questionService.getQuestionByCategory(category);
       return ResponseEntity.ok(questions);

    }

    // generate
    // get questions by question id
    // calculate score

}
