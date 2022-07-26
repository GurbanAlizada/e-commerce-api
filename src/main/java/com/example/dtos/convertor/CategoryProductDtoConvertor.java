package com.example.dtos.convertor;

import com.example.dtos.CategoryProductDto;
import com.example.model.Product;
import org.springframework.stereotype.Component;

@Component
public class CategoryProductDtoConvertor {

    public CategoryProductDto convertToCategortProduct(Product product){
       return new CategoryProductDto(
                product.getId(),
                product.getProductName(),
                product.getUnitPrice(),
                product.getUnitsInStock(),
                product.getQuantityPerUnit()
        );
    }





}
