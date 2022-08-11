package com.iamsajan.examservice.repository;

import com.iamsajan.examservice.model.exam.Category;
import com.iamsajan.examservice.model.exam.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Long> {
    List<Quiz> findByCategory(Category category);

    List<Quiz> findByActive(Boolean status);

    List<Quiz> findByCategoryAndActive(Category category, Boolean status);
}
