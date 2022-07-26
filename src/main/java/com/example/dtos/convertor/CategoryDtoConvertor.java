package com.example.dtos.convertor;

import com.example.dtos.CategoryDto;
import com.example.model.Category;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class CategoryDtoConvertor {

    private final CategoryProductDtoConvertor categoryProductDtoConvertor;

    public CategoryDtoConvertor(CategoryProductDtoConvertor categoryProductDtoConvertor) {
        this.categoryProductDtoConvertor = categoryProductDtoConvertor;
    }


    public CategoryDto convertToCategoryDto(Category category){
        return new CategoryDto(
                category.getCategoryId(),
                category.getCategoryName(),
                category.getProducts().stream()
                        .map(n->categoryProductDtoConvertor.convertToCategortProduct(n))
                        .collect(Collectors.toList())
        );
    }


}
