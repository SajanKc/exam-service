package com.iamsajan.examservice.controller;

import com.iamsajan.examservice.model.exam.Question;
import com.iamsajan.examservice.model.exam.Quiz;
import com.iamsajan.examservice.service.QuestionService;
import com.iamsajan.examservice.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private QuizService quizService;

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Question createQuestion(@RequestBody Question question) {
        return questionService.addQuestion(question);
    }

    @GetMapping("/{qId}")
    @ResponseStatus(code = HttpStatus.OK)
    public Question getQuestions(@PathVariable("qId") Long qId) {
        return questionService.getQuestion(qId);
    }

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public Set<Question> getQuestions() {
        return questionService.getQuestions();
    }

    // Get all questions of any quiz
    @GetMapping("/quiz/{qId}")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Question> getQuestionsOfQuiz(@PathVariable("qId") Long qId) {
        Quiz quiz = quizService.getQuiz(qId);
        if (quiz != null) {
            Set<Question> questions = quiz.getQuestions();
            List<Question> questionList = new ArrayList(questions);
            if (questionList.size() > Integer.parseInt(quiz.getNumberOfQuestions())) {
                questionList = questionList.subList(0, Integer.parseInt(quiz.getNumberOfQuestions()));
            }

            // setting answer value blank before sending to client
            questionList.forEach(question -> {
                question.setAnswer("");
            });

            Collections.shuffle(questionList);
            return questionList;
        }
        return null;
    }

    // for admin
    @GetMapping("/quiz/all/{qId}")
    @ResponseStatus(code = HttpStatus.OK)
    public Set<Question> getAllQuestionsOfQuiz(@PathVariable("qId") Long qid) {
        Quiz quiz = new Quiz();
        quiz.setQuizId(qid);

        Set<Question> questions = this.questionService.getQuestionsOfQuiz(quiz);

        return questions;
    }

    @PutMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Question updateQuestion(@PathVariable("id") Long id, @RequestBody Question question) {
        return questionService.updateQuestion(id, question);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteQuestion(@PathVariable("id") Long id) {
        questionService.deleteQuestion(id);
    }

    @PostMapping("/submit-quiz")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public Map<String, Object> submitQuizAnswer(@RequestBody List<Question> questions) {
        return questionService.submitQuizAnswer(questions);
    }
}
