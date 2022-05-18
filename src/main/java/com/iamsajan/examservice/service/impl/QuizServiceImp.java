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
    public Quiz updateQuiz(Long id, Quiz quiz) {
        Optional<Quiz> optionalQuiz = quizRepository.findById(id);
        if (optionalQuiz.isPresent()) {
            Quiz updateQuiz = optionalQuiz.get();
            updateQuiz.setTitle(quiz.getTitle());
            updateQuiz.setDescription(quiz.getDescription());
            updateQuiz.setMaxMarks(quiz.getMaxMarks());
            updateQuiz.setNumberOfQuestions(quiz.getNumberOfQuestions());
            return quizRepository.save(updateQuiz);
        }
        return null;
    }

    @Override
    public Set<Quiz> getQuizzes() {
        return new LinkedHashSet<>(quizRepository.findAll());
    }

    @Override
    public Quiz getQuiz(Long quizId) {
        Optional<Quiz> quiz = quizRepository.findById(quizId);
        if (quiz.isPresent()) {
            System.out.println("Get quiz called");
            return quiz.get();
        }
        return null;
    }

    @Override
    public void deleteQuiz(Long quizId) {
        quizRepository.deleteById(quizId);
    }
}
