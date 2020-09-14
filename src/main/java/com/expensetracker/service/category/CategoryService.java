package com.expensetracker.service.category;

import com.expensetracker.model.Category;

import java.util.Collection;
import java.util.Optional;

public interface CategoryService {

    Category save(Category category);

    Optional<Category> findById(Long categoryId);

    Category update(Category category);

    void deleteById(Long categoryId);

    Collection<Category> findAll();

}
