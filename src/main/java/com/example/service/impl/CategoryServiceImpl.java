package com.example.service.impl;


import com.example.exception.CategoryNotFoundException;
import com.example.model.Category;
import com.example.repository.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    protected Category findCategoryById(int id){
        return categoryRepository.findById(id).orElseThrow(()-> new CategoryNotFoundException("Aradiginiz kategory yok"));

    }





}
