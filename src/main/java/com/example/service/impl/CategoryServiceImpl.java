package com.example.service.impl;


import com.example.dtos.CategoryDto;
import com.example.dtos.convertor.CategoryDtoConvertor;
import com.example.dtos.request.CategoryRequest;
import com.example.exception.CategoryNotFoundException;
import com.example.model.Category;
import com.example.repository.CategoryRepository;
import com.example.service.inter.CategoryServiceInter;
import com.example.utilities.results.DataResult;
import com.example.utilities.results.Result;
import com.example.utilities.results.SuccessDataResult;
import com.example.utilities.results.SuccessResult;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryServiceInter {

    private final CategoryRepository categoryRepository;
    private final CategoryDtoConvertor categoryDtoConvertor;


    public CategoryServiceImpl(CategoryRepository categoryRepository, CategoryDtoConvertor categoryDtoConvertor) {
        this.categoryRepository = categoryRepository;
        this.categoryDtoConvertor = categoryDtoConvertor;
    }

    protected Category findCategoryById(int id){
        return categoryRepository.findById(id).orElseThrow(()-> new CategoryNotFoundException("Aradiginiz kategory yok"));
    }


    @Override
    public DataResult<List<CategoryDto>> getAll() {
        List<Category> categories = categoryRepository.findAll();
        return  new SuccessDataResult<>(
                categories.stream()
                        .map(n->categoryDtoConvertor.convertToCategoryDto(n))
                        .collect(Collectors.toList()),
                "Data Listelendi"
        );
    }

    @Override
    public DataResult<CategoryDto> getById(int id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(()->new CategoryNotFoundException("Boyle bir kategory yok"));
        return new SuccessDataResult<>(
                categoryDtoConvertor.convertToCategoryDto(category),
                "Data Listelendi"
        );
    }

    @Override
    public DataResult<CategoryDto> getByCategoryName(String categoryName) {
        Category category = categoryRepository.getByCategoryName(categoryName);
        return new SuccessDataResult<>(
                categoryDtoConvertor.convertToCategoryDto(category),
                "Data Listelendi"
        );
    }

    @Override
    public Result add(CategoryRequest categoryRequest) {
        Category category = new Category(
                0,
                categoryRequest.getCategoryName(),
                null
        );
        Category addedCategory = categoryRepository.save(category);
        return new SuccessResult("Kategori eklendi");
    }

    @Override
    public Result deleteCategory(int id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(()->new CategoryNotFoundException("Kategori Bulunmadi"));
        categoryRepository.delete(category);
        return new SuccessResult(
                "Kategori basari ile silindi"
        );
    }

    @Override
    public Result updateCategory(int id, CategoryRequest categoryRequest) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(()->new CategoryNotFoundException("Kategory Bulunamadi"));
        category.setCategoryName(categoryRequest.getCategoryName());
        categoryRepository.save(category);
        return new SuccessResult("Kategori basarile guncellendi");
    }


}
