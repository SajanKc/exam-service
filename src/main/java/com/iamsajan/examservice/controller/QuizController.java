package com.iamsajan.examservice.controller;

import com.iamsajan.examservice.model.exam.Category;
import com.iamsajan.examservice.model.exam.Quiz;
import com.iamsajan.examservice.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @PostMapping
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public Quiz createQuiz(@RequestBody Quiz quiz) {
        return quizService.addQuiz(quiz);
    }

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public Set<Quiz> getQuizes() {
        return quizService.getQuizzes();
    }

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Quiz getQuiz(@PathVariable("id") Long id) {
        return quizService.getQuiz(id);
    }

    @GetMapping("/category/{cid}")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Quiz> getQuizzesOfCategory(@PathVariable("cid") Long cid) {
        Category category = new Category();
        category.setCId(cid);
        return quizService.getQuizzesOfCategory(category);
    }

    @GetMapping("/active")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Quiz> getActiveQuizzes() {
        return this.quizService.getActiveQuizzes();
    }

    @GetMapping("/category/active/{cid}")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Quiz> getActiveQuizzesOfCategory(@PathVariable("cid") Long cid) {
        Category category = new Category();
        category.setCId(cid);
        return this.quizService.getActiveQuizzesOfCategory(category);
    }

    @PutMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Quiz updateQuiz(@PathVariable("id") Long id, @RequestBody Quiz quiz) {
        return quizService.updateQuiz(id, quiz);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteQuiz(@PathVariable("id") Long id) {
        quizService.deleteQuiz(id);
    }
}
