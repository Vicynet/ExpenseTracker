package com.expensetracker.service.category;

import com.expensetracker.model.Category;
import com.expensetracker.repository.CategoryRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Mockito.*;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class CategoryServiceTest {

    @Mock
    CategoryRepository categoryRepository;

    @InjectMocks
    CategoryService categoryService;

    Category testCategory;

    @BeforeEach
    void setUp() {
        categoryService = new CategoryServiceImpl();
        testCategory = new Category();
        MockitoAnnotations.initMocks(this);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void save() {

        when(categoryService.save(testCategory)).thenReturn(testCategory);
        categoryService.save(testCategory);

        verify(categoryRepository, times(1)).save(testCategory);

    }

    @Test
    void findById() {

        when(categoryService.findById((long) 1)).thenReturn(Optional.of(testCategory));
        categoryService.findById(testCategory.getId());

        verify(categoryRepository, times(1)).findById(testCategory.getId());
    }

    @Test
    void update() {

        when(categoryService.update(testCategory)).thenReturn(testCategory);
        categoryService.update(testCategory);

        verify(categoryRepository, times(1)).save(testCategory);

    }

    @Test
    void deleteById() {

        doNothing().when(categoryRepository).delete(testCategory);
        categoryService.deleteById(testCategory.getId());

        verify(categoryRepository, times(1)).deleteById(testCategory.getId());

    }

    @Test
    void findAll() {

        Collection<Category> categories = new ArrayList<>();
        when(categoryService.findAll()).thenReturn(categories);
        categoryService.findAll();

        verify(categoryRepository, times(1)).findAll();

    }
}