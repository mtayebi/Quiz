package com.microservice.questionservice.controller;

import com.microservice.questionservice.dto.Answers;
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

    // generate quiz
    @GetMapping("/generate")
    public ResponseEntity<List<Long>> generate(@RequestParam String category, @RequestParam int numOfQ){
        List<Long> questionsListNumber = questionService.getnearte(category, numOfQ);
        return ResponseEntity.ok(questionsListNumber);
    }

    // get questions by list of question ids
    @PostMapping("/get-questions")
    public ResponseEntity<List<QuestionDto>> getQuestionsByListOfIds(@RequestBody List<Long> questionsList){
        List<QuestionDto> questionDtos = questionService.getListOfQuestions(questionsList);
        return ResponseEntity.ok(questionDtos);
    }
    // calculate score
    @PostMapping("/get-score")
    public ResponseEntity<String> getScore(@RequestBody List<Answers> answers){
        float score = questionService.getScore(answers);
        return ResponseEntity.ok("You passed the exam by grade: " + score );
    }
}
