package com.iamsajan.examservice.controller;


import com.iamsajan.examservice.model.exam.Category;
import com.iamsajan.examservice.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Category createCategory(@RequestBody Category category) {
        return categoryService.addCategory(category);
    }

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public Set<Category> getAllCategory() {
        return categoryService.getCategories();
    }

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Category getCategory(@PathVariable("id") Long id) {
        return categoryService.getCategory(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Category updateCategory(@PathVariable("id") Long id, @RequestBody Category category) {
        return this.categoryService.updateCategory(id, category);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteCategoryById(@PathVariable("id") Long id) {
        categoryService.deleteCategory(id);
    }
}
