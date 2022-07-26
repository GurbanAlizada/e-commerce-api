package com.example.controller;


import com.example.dtos.CategoryDto;
import com.example.dtos.request.CategoryRequest;
import com.example.model.Category;
import com.example.service.impl.CategoryServiceImpl;
import com.example.utilities.results.DataResult;
import com.example.utilities.results.Result;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryServiceImpl categoryService;

    public CategoryController(CategoryServiceImpl categoryService) {
        this.categoryService = categoryService;
    }


    @GetMapping("/getall")
    public DataResult<List<CategoryDto>> getAll(){
        return categoryService.getAll();
    }



    @GetMapping("/getById")
    public DataResult<CategoryDto> getById(int id){
        return categoryService.getById(id);
    }


    @GetMapping("/getByCategoryName")
    public DataResult<CategoryDto> getByCategoryName(String categoryName){
        return categoryService.getByCategoryName(categoryName);
    }



    @PostMapping("/add")
    public Result add( @Valid @RequestBody CategoryRequest categoryRequest){
        return categoryService.add(categoryRequest);
    }





}
