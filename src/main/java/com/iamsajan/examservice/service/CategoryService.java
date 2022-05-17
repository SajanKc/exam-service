package com.iamsajan.examservice.service;

import com.iamsajan.examservice.model.exam.Category;

import java.util.Set;

public interface CategoryService {
    public Category addCategory(Category category);

    public Category updateCategory(Long id, Category category);

    public Set<Category> getCategories();

    public Category getCategory(Long categoryId);

    public void deleteCategory(Long categoryId);
}
