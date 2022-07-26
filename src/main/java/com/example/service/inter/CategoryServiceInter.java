package com.example.service.inter;

import com.example.dtos.CategoryDto;
import com.example.dtos.request.CategoryRequest;
import com.example.model.Category;
import com.example.utilities.results.DataResult;
import com.example.utilities.results.Result;

import java.util.List;

public interface CategoryServiceInter {

    DataResult<List<CategoryDto>> getAll();

    DataResult<CategoryDto> getById(int id);

    DataResult<CategoryDto> getByCategoryName(String categoryName);

    Result add(CategoryRequest categoryRequest);

}
