package com.microservice.quizservice.config;

import com.microservice.quizservice.dto.Answers;
import com.microservice.quizservice.dto.QuestionDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("QUESTION-SERVICE")
public interface FeignQuizConfig {
    // generate quiz
    @GetMapping("question/generate")
    ResponseEntity<List<Long>> generate(@RequestParam String category, @RequestParam int numOfQ);

    // get questions by list of question ids
    @PostMapping("question/get-questions")
    ResponseEntity<List<QuestionDto>> getQuestionsByListOfIds(@RequestBody List<Long> questionsList);
    // calculate score
    @PostMapping("question/get-score")
    ResponseEntity<String> getScore(@RequestBody List<Answers> answers);
}
