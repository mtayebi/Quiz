package com.quiz.quizapp.mapper;

import com.quiz.quizapp.dto.QuestionDto;
import com.quiz.quizapp.model.Question;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface QuestionToQuestionDto {
    QuestionToQuestionDto INSTANCE = Mappers.getMapper(QuestionToQuestionDto.class);

    @Mapping(source = "question.questionTitle", target = "question")
    QuestionDto getQuestionDto(Question question);
}
