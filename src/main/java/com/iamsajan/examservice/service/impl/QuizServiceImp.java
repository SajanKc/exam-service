package com.iamsajan.examservice.service.impl;

import com.iamsajan.examservice.model.exam.Quiz;
import com.iamsajan.examservice.repository.QuizRepository;
import com.iamsajan.examservice.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class QuizServiceImp implements QuizService {

    @Autowired
    private QuizRepository quizRepository;

    @Override
    public Quiz addQuiz(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    @Override
    public Quiz updateQuiz(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    @Override
    public Set<Quiz> getQuizzes() {
        return new LinkedHashSet<>(quizRepository.findAll());
    }

    @Override
    public Quiz getQuiz(Long quizId) {
        Optional<Quiz> quiz = quizRepository.findById(quizId);
        if (quiz.isPresent())
            return quiz.get();
        return null;
    }

    @Override
    public void deleteQuiz(Long quizId) {
        quizRepository.deleteById(quizId);
    }
}
