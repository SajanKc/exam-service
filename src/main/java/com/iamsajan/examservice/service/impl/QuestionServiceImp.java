package com.iamsajan.examservice.service.impl;

import com.iamsajan.examservice.model.exam.Question;
import com.iamsajan.examservice.model.exam.Quiz;
import com.iamsajan.examservice.repository.QuestionRepository;
import com.iamsajan.examservice.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class QuestionServiceImp implements QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public Question addQuestion(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public Question updateQuestion(Long id, Question question) {
        Optional<Question> optionalQuestion = questionRepository.findById(id);
        if (optionalQuestion.isPresent()) {
            Question updatedQuestion = optionalQuestion.get();
            updatedQuestion.setContent(question.getContent());
            updatedQuestion.setImage(question.getImage());
            updatedQuestion.setOption1(question.getOption1());
            updatedQuestion.setOption2(question.getOption2());
            updatedQuestion.setOption3(question.getOption3());
            updatedQuestion.setOption4(question.getOption4());
            updatedQuestion.setAnswer(question.getAnswer());
        }
        return null;
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
