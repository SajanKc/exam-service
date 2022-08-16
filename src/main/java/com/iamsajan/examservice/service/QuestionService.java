package com.iamsajan.examservice.service;

import com.iamsajan.examservice.model.exam.Question;
import com.iamsajan.examservice.model.exam.Quiz;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface QuestionService {
    public Question addQuestion(Question question);

    public Question updateQuestion(Long id, Question question);

    public Set<Question> getQuestions();

    public Question getQuestion(Long questionId);

    public void deleteQuestion(Long questionId);

    public Set<Question> getQuestionsOfQuiz(Quiz quiz);

    public Map<String, Object> submitQuizAnswer(List<Question> questions);
}
