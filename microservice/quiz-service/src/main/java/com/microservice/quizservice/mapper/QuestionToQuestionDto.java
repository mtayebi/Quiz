package com.microservice.quizservice.mapper;


import com.microservice.quizservice.dto.QuestionDto;
import com.microservice.quizservice.model.Question;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface QuestionToQuestionDto {
    QuestionToQuestionDto INSTANCE = Mappers.getMapper(QuestionToQuestionDto.class);

    @Mapping(source = "question.questionTitle", target = "question")
    QuestionDto getQuestionDto(Question question);
}
