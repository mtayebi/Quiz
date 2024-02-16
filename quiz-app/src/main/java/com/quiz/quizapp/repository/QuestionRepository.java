package com.quiz.quizapp.repository;

import com.quiz.quizapp.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {

    List<Question> findByCategory(String category);
    @Query(value = "SELECT * FROM Question q WHERE q.category=:category order by Random() limit :numOfQuestions", nativeQuery = true)
    List<Question> generateQuiz(String category, int numOfQuestions);
}
