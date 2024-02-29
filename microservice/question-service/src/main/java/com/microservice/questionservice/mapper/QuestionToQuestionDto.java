package com.microservice.questionservice.mapper;

import com.microservice.questionservice.dto.QuestionDto;
import com.microservice.questionservice.model.Question;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface QuestionToQuestionDto {
    QuestionToQuestionDto INSTANCE = Mappers.getMapper(QuestionToQuestionDto.class);

    @Mapping(source = "question.questionTitle", target = "question")
    QuestionDto getQuestionDto(Question question);
}
