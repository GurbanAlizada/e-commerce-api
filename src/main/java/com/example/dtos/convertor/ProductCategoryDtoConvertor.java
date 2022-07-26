package com.example.dtos.convertor;


import com.example.dtos.ProductCategoryDto;
import com.example.model.Category;
import org.springframework.stereotype.Component;

@Component
public class ProductCategoryDtoConvertor {

    public ProductCategoryDto convertToProductCategoryDto(Category category){
        return new ProductCategoryDto(
                category.getCategoryId(),
                category.getCategoryName()
        );
    }



    public Category convertToCategory (ProductCategoryDto productCategoryDto){
        return new Category(
                productCategoryDto.getId(),
                productCategoryDto.getCategoryName(),
                null
        );




    }




}
