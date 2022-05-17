package com.iamsajan.examservice.service.impl;

import com.iamsajan.examservice.model.exam.Category;
import com.iamsajan.examservice.repository.CategoryRepository;
import com.iamsajan.examservice.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category addCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(Long id, Category category) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if (optionalCategory.isPresent()) {
            Category updatedCategory = optionalCategory.get();
            updatedCategory.setTitle(category.getTitle());
            updatedCategory.setDescription(category.getDescription());
            return categoryRepository.save(updatedCategory);
        }
        return null;
    }

    @Override
    public Set<Category> getCategories() {
        return new LinkedHashSet<>(categoryRepository.findAll());
    }

    @Override
    public Category getCategory(Long categoryId) {
        Optional<Category> category = categoryRepository.findById(categoryId);
        if (category.isPresent())
            return category.get();
        return null;
    }

    @Override
    public void deleteCategory(Long categoryId) {
        categoryRepository.deleteById(categoryId);
    }
}
