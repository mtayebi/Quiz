package com.microservice.questionservice.repository;

import com.microservice.questionservice.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {

    List<Question> findByCategory(String category);
    @Query(value = "SELECT q.id FROM Question q WHERE q.category=:category order by Random() limit :numOfQuestions", nativeQuery = true)
    List<Long> generateQuiz(String category, int numOfQuestions);
}
