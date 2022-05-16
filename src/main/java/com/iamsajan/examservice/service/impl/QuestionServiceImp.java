package com.iamsajan.examservice.service.impl;

import com.iamsajan.examservice.model.exam.Question;
import com.iamsajan.examservice.model.exam.Quiz;
import com.iamsajan.examservice.repository.QuestionRepository;
import com.iamsajan.examservice.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

public class QuestionServiceImp implements QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public Question addQuestion(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public Question updateQuestion(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public Set<Question> getQuestions() {
        return new LinkedHashSet<>(questionRepository.findAll());
    }

    @Override
    public Question getQuestion(Long questionId) {
        Optional<Question> question = questionRepository.findById(questionId);
        if (question.isPresent())
            return question.get();
        return null;
    }

    @Override
    public void deleteQuestion(Long questionId) {
        questionRepository.deleteById(questionId);
    }

    @Override
    public Set<Question> getQuestionsOfQuiz(Quiz quiz) {
        return questionRepository.findByQuiz(quiz);
    }
}
