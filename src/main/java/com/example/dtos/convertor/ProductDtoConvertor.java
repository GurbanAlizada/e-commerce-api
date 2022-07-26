package com.example.dtos.convertor;

import com.example.dtos.ProductDto;
import com.example.model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductDtoConvertor {


    private final CategoryDtoConvertor  categoryDtoConvertor;
    private final ProductCategoryDtoConvertor productCategoryDtoConvertor;

    public ProductDtoConvertor(CategoryDtoConvertor categoryDtoConvertor, ProductCategoryDtoConvertor productCategoryDtoConvertor) {
        this.categoryDtoConvertor = categoryDtoConvertor;
        this.productCategoryDtoConvertor = productCategoryDtoConvertor;
    }


    public ProductDto convertToProductDto(Product product){
        return new ProductDto(
                product.getId(),
                productCategoryDtoConvertor.convertToProductCategoryDto(product.getCategory()),
                product.getProductName(),
                product.getUnitPrice(),
                product.getUnitsInStock(),
                product.getQuantityPerUnit()
        );




    }




/*
    public Product convertToProduct(ProductDto productDto){
        return new Product(
                productDto.getId(),
                null,               // Category category
                productDto.getProductName(),
                productDto.getUnitPrice(),
                productDto.getUnitsInStock(),
                productDto.getQuantityPerUnit()
        );
        productCategoryDtoConvertor.convertToCategory();

    }


    */




}
